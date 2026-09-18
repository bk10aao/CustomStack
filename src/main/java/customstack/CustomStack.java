package customstack;

import java.io.Serial;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterators;

import static java.lang.System.arraycopy;
import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;
import static java.util.Objects.checkFromToIndex;
import static java.util.Objects.checkIndex;
import static java.util.Objects.requireNonNull;

/**
 * A resizable, array-backed stack that doubles as a random-access {@link List}.
 *
 * <p>{@code CustomStack} behaves like {@link java.util.Stack} (offering
 * {@link #push(Object)}, {@link #pop()}, {@link #peek()}, {@link #empty()} and
 * {@link #search(Object)}) while also implementing the full {@link List} contract
 * via {@link AbstractList}, so it can be used anywhere a {@code List} is expected.
 * Elements are stored in an internal {@code Object[]} that grows automatically as
 * needed, similar to {@link java.util.ArrayList} and {@link java.util.Vector}.
 *
 * <p>The "top" of the stack corresponds to the end of the list (the highest
 * index), so {@link #push(Object)} appends to the end and {@link #pop()} removes
 * from the end.
 *
 * <p><b>Thread safety:</b> unlike {@code ArrayList}, most mutating and reading
 * methods on this class are {@code synchronized} on the instance, mirroring the
 * legacy {@code Vector}/{@code Stack} synchronization model. However, compound
 * operations (such as iterating while another thread mutates the stack) are not
 * atomic and may still require external synchronization. Iterators and list
 * iterators returned by this class operate over a <em>snapshot</em> of the stack
 * taken at the time of the call, rather than a live, fail-fast view.
 *
 * <p>This class permits {@code null} elements.
 *
 * @param <E> the type of elements held in this stack
 * @author Benjamin Kane
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn</a>
 * @see <a href="https://github.com/bk10aao">GitHub account bk10aao</a>
 * @see <a href="https://github.com/bk10aao/CustomStack>Repository</a>
 */
public class CustomStack<E> extends AbstractList<E> implements RandomAccess, Cloneable, java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Backing array. Only indices {@code [0, size)} hold live elements.
     */
    private Object[] stack;

    /**
     * The number of elements currently stored in the stack.
     */
    private int size = 0;

    /**
     * Constructs an empty stack with a default initial capacity of 16.
     */
    public CustomStack() {
        this(16);
    }

    /**
     * Constructs a stack containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     *
     * @param c the collection whose elements are to be placed into this stack
     * @throws NullPointerException if the specified collection is {@code null}
     */
    public CustomStack(final Collection<? extends E> c) {
        this(c.size());
        addAll(c);
    }

    /**
     * Constructs an empty stack with the specified initial capacity, rounded
     * up internally to the next power of two (minimum 16).
     *
     * @param initialCapacity the desired initial capacity
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public CustomStack(final int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();
        this.stack = new Object[calculateCapacity(0, initialCapacity)];
    }

    /**
     * Appends the specified element to the top of this stack.
     *
     * @param e the element to be appended
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public synchronized boolean add(final E e) {
        ensureAndInsert(size, e);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this stack,
     * shifting any subsequent elements one position toward the top.
     *
     * @param index   index at which the element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index > size()})
     */
    public synchronized void add(final int index, final E element) {
        checkIndex(index, size + 1);
        ensureAndInsert(index, element);
    }

    /**
     * Appends all the elements in the specified collection to the top of
     * this stack, in the order returned by the collection's iterator.
     *
     * @param c collection containing elements to be added
     * @return {@code true} if this stack changed as a result of the call
     * @throws NullPointerException if the specified collection is {@code null}
     */
    public synchronized boolean addAll(final Collection<? extends E> c) {
        requireNonNull(c);
        if (c.isEmpty())
            return false;
        final int newSize = c.size();
        ensureCapacity(size + newSize);
        if (c instanceof List<?> list && c instanceof RandomAccess) {
            for (int i = 0; i < newSize; i++)
                stack[size++] = list.get(i);
        } else
            for (E e : c)
                stack[size++] = e;
        return true;
    }

    /**
     * Inserts all the elements in the specified collection into this stack,
     * starting at the specified position, shifting any subsequent elements
     * toward the top.
     *
     * @param index index at which to insert the first element from the collection
     * @param c     collection containing elements to be added
     * @return {@code true} if this stack changed as a result of the call
     * @throws NullPointerException      if the specified collection is {@code null}
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index > size()})
     */
    public synchronized boolean addAll(final int index, final Collection<? extends E> c) {
        requireNonNull(c);
        checkIndex(index, size + 1);
        if (c.isEmpty())
            return false;
        return ensureAndInsertAll(index, c);
    }

    /**
     * Returns the current capacity of the backing array, i.e. the number of
     * elements this stack can hold before it needs to grow.
     *
     * @return the current capacity
     */
    public synchronized int capacity() {
        return stack.length;
    }

    /**
     * Removes all the elements from this stack. The stack will be empty
     * after this call returns; the backing array's capacity is left unchanged.
     */
    public synchronized void clear() {
        fill(stack, 0, size, null);
        size = 0;
    }

    /**
     * Returns a shallow copy of this stack. The elements themselves are not
     * copied.
     *
     * @return a shallow copy of this stack
     */
    @Override
    public synchronized CustomStack<E> clone() {
        CustomStack<E> copy = new CustomStack<>();
        copy.stack = Arrays.copyOf(stack, stack.length);
        copy.size = this.size;
        return copy;
    }

    /**
     * Returns {@code true} if this stack contains all the elements in the
     * specified collection.
     *
     * @param c collection to be checked for containment in this stack
     * @return {@code true} if this stack contains all the elements in the
     *         specified collection
     * @throws NullPointerException if the specified collection is {@code null}
     */
    public synchronized boolean containsAll(final Collection<?> c) {
        requireNonNull(c);
        if (c.isEmpty())
            return true;
        Set<?> values = new HashSet<>(c);
        for (int i = 0; i < size; i++) {
            values.remove(stack[i]);
            if (values.isEmpty())
                return true;
        }
        return false;
    }

    /**
     * Increases the capacity of this stack, if necessary, to ensure that it
     * can hold at least {@code minCapacity} elements without needing to grow
     * again. The actual capacity is rounded up to the next power of two.
     *
     * @param minCapacity the desired minimum capacity
     */
    public synchronized void ensureCapacity(final int minCapacity) {
        if (minCapacity > stack.length)
            stack = Arrays.copyOf(stack, calculateCapacity(stack.length, minCapacity));
    }


    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains no elements
     */
    public synchronized boolean empty() {
        return size == 0;
    }

    /**
     * Returns the element at the specified position in this stack.
     *
     * @param index index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public synchronized E get(final int index) {
        checkIndex(index, size);
        return (E) stack[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this stack, or -1 if this stack does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public synchronized int indexOf(final Object o) {
        for(int i = 0; i < size; i++)
            if (Objects.equals(stack[i], o))
                return i;
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this stack, searching forward from the given index (inclusive), or -1
     * if the element is not found.
     *
     * @param o     element to search for
     * @param index index to start the search from (values below 0 are treated as 0)
     * @return the index of the first occurrence at or after {@code index}, or -1 if not found
     */
    public synchronized int indexOf(final Object o, final int index) {
        for(int i = Math.max(index, 0); i < size; i++)
            if (Objects.equals(stack[i], o))
                return i;
        return -1;
    }

    /**
     * Returns an iterator over a snapshot of the elements in this stack, in
     * proper sequence (from the bottom of the stack to the top). Because the
     * iterator operates over a copy of the backing array taken at call time,
     * it does not reflect subsequent modifications to the stack and does not
     * throw {@link java.util.ConcurrentModificationException}.
     *
     * @return an iterator over the elements in this stack
     */
    public synchronized Iterator<E> iterator() {
        E[] snapshot = (E[]) copyOfRange(stack, 0, size);
        return asList(snapshot).iterator();
    }

    /**
     * Returns the index of the last occurrence of the specified element in
     * this stack, searching backward from the given index, or -1 if the
     * element is not found.
     *
     * @param o     element to search for
     * @param index index to start the backward search from; if greater than
     *              or equal to the current size, the search starts from the top
     * @return the index of the last occurrence at or before {@code index}, or -1 if not found
     */
    public synchronized int lastIndexOf(final Object o, final int index) {
        for (int i = index >= size ? size - 1 : index; i >= 0; i--)
            if (Objects.equals(stack[i], o))
                return i;
        return -1;
    }

    /**
     * Returns a list iterator over a snapshot of the elements in this stack
     * (in proper sequence), starting at the beginning of the stack. As with
     * {@link #iterator()}, the returned iterator reflects a copy of the stack
     * taken at call time and does not support structural modification of this
     * stack through the iterator.
     *
     * @return a list iterator over the elements in this stack
     */
    public synchronized ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /**
     * Returns a list iterator over a snapshot of the elements in this stack
     * (in proper sequence), starting at the specified position.
     *
     * @param index index of the first element to be returned from the list
     *              iterator (by a call to {@code next})
     * @return a list iterator over the elements in this stack, starting at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index > size()})
     */
    public synchronized ListIterator<E> listIterator(final int index) {
        Objects.checkIndex(index, size + 1);
        E[] snapshot = (E[]) copyOfRange(stack, 0, size);
        return asList(snapshot).listIterator(index);
    }

    /**
     * Looks at the element at the top of this stack without removing it.
     *
     * @return the element at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public synchronized E peek() {
        if(size == 0)
            throw new EmptyStackException();
        return (E) stack[size - 1];
    }

    /**
     * Removes the element at the top of this stack and returns it.
     *
     * @return the element at the top of this stack (the last item pushed)
     * @throws EmptyStackException if this stack is empty
     */
    public synchronized E pop() {
        if(size == 0)
            throw new EmptyStackException();
        E item = (E) stack[--size];
        stack[size] = null;
        return item;
    }

    /**
     * Pushes an item onto the top of this stack. This has exactly the same
     * effect as {@link #add(Object) add(item)}.
     *
     * @param item the item to be pushed onto this stack
     * @return the {@code item} argument, for convenience in chaining
     */
    public synchronized E push(final E item) {
        ensureAndInsert(size, item);
        return item;
    }

    /**
     * Removes the element at the specified position in this stack, shifting
     * any subsequent elements one position toward the bottom.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public synchronized E remove(final int index) {
        checkIndex(index, size);
        E item = (E) stack[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            arraycopy(stack, index + 1, stack, index, numMoved);
        stack[--size] = null;
        return item;
    }

    /**
     * Removes the first occurrence of the specified element from this stack,
     * if it is present, shifting any subsequent elements toward the bottom.
     *
     * @param o element to be removed from this stack, if present
     * @return {@code true} if this stack contained the specified element
     */
    public synchronized boolean remove(final Object o) {
        for(int i = 0; i < size; i++)
            if (Objects.equals(stack[i], o)) {
                final int numMoved = size - i - 1;
                if (numMoved > 0)
                    System.arraycopy(stack, i + 1, stack, i, numMoved);
                stack[--size] = null;
                return true;
            }
        return false;
    }

    /**
     * Removes from this stack all of its elements that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be removed from this stack
     * @return {@code true} if this stack changed as a result of the call
     * @throws NullPointerException if the specified collection is {@code null}
     */
    public synchronized boolean removeAll(final Collection<?> c) {
        requireNonNull(c);
        if (size == 0 || c.isEmpty())
            return false;
        Set<?> values = (c instanceof Set) ? (Set<?>) c : new HashSet<>(c);
        int x = 0;
        boolean modified = false;
        for(int i = 0; i < size; i++)
            if (!values.contains(stack[i]))
                stack[x++] = stack[i];
            else
                modified = true;
        if (modified) {
            for (int i = x; i < size; i++)
                stack[i] = null;
            size = x;
        }
        return modified;
    }

    /**
     * Retains only the elements in this stack that are contained in the
     * specified collection; all other elements are removed.
     *
     * @param c collection containing elements to be retained in this stack
     * @return {@code true} if this stack changed as a result of the call
     * @throws NullPointerException if the specified collection is {@code null}
     */
    public synchronized boolean retainAll(final Collection<?> c) {
        requireNonNull(c);
        if (isEmpty() || c == this)
            return false;
        Set<?> set = (c instanceof Set) ? (Set<?>) c : new HashSet<>(c);
        boolean modified = false;
        int index = 0;
        for (int i = 0; i < size; i++)
            if (set.contains(stack[i]))
                stack[index++] = stack[i];
            else
                modified = true;
        if(modified) {
            fill(stack, index, size, null);
            size = index;
        }
        return modified;
    }

    /**
     * Returns the 1-based position of an object on this stack, measured from
     * the top. The topmost element is at distance 1.
     *
     * @param o the desired object
     * @return the 1-based distance from the top of the stack, or -1 if the
     *         object is not present
     */
    public synchronized int search(final Object o) {
        if(o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (stack[i] == null)
                    return size - i;
            return -1;
        }
        for(int i = size - 1; i >= 0; i--)
            if (stack[i].equals(o))
                return size - i;
        return -1;
    }

    /**
     * Replaces the element at the specified position in this stack with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public synchronized E set(final int index, final E element) {
        checkIndex(index, size);
        E previous = (E) stack[index];
        stack[index] = element;
        return previous;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public synchronized int size() {
        return size;
    }

    /**
     * Sorts the elements of this stack according to the order induced by the
     * specified comparator.
     *
     * @param c the comparator used to compare elements; a {@code null} value
     *          indicates that the elements' {@linkplain Comparable natural
     *          ordering} should be used
     */
    public synchronized void sort(final Comparator<? super E> c) {
        Comparator<? super Object> comparator = (Comparator<? super Object>) c;
        Arrays.sort(stack, 0, size, comparator);
    }

    /**
     * Returns a view of the portion of this stack between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. The
     * returned list is backed by this stack, so structural changes made
     * through the returned list are reflected in this stack.
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this stack
     * @throws IndexOutOfBoundsException if the endpoint indices are out of range
     *         {@code (fromIndex < 0 || toIndex > size || fromIndex > toIndex)}
     */
    public synchronized List<E> subList(final int fromIndex, final int toIndex) {
        checkFromToIndex(fromIndex, toIndex, size);
        return new SubStackList<>(this, fromIndex, toIndex);
    }

    /**
     * Creates a late-binding and fail-fast {@link Spliterator} over the
     * elements in this stack, reporting {@link Spliterator#ORDERED},
     * {@link Spliterator#SIZED}, {@link Spliterator#SUBSIZED} and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @return a {@code Spliterator} over the elements in this stack
     */
    public synchronized Spliterator<E> spliterator() {
        return Spliterators.spliterator(stack, 0, size,
                Spliterator.ORDERED |
                                    Spliterator.SIZED |
                                    Spliterator.SUBSIZED |
                                    Spliterator.IMMUTABLE);
    }

    /**
     * Returns an array containing all the elements in this stack, in
     * proper sequence (from bottom to top).
     *
     * @return an array containing all the elements in this stack
     */
    public synchronized Object[] toArray() {
        return copyOfRange(stack, 0, size);
    }

    /**
     * Returns an array containing all the elements in this stack, in
     * proper sequence; the runtime type of the returned array is that of the
     * specified array. If the stack fits in the specified array, it is
     * returned therein; otherwise, a new array is allocated with the runtime
     * type of the specified array and the size of this stack.
     *
     * @param a   the array into which the elements of this stack are to be
     *            stored, if it is big enough; otherwise, a new array of the
     *            same runtime type is allocated for this purpose
     * @param <T> the runtime type of the array to contain the stack
     * @return an array containing the elements of this stack
     * @throws NullPointerException if the specified array is {@code null}
     */
    public synchronized <T> T[] toArray(final T[] a) {
        requireNonNull(a);
        int size = size();
        if (a.length < size)
            return (T[]) copyOfRange(stack, 0, size, a.getClass());
        arraycopy(stack, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns a string representation of this stack, consisting of the
     * elements from bottom to top enclosed in square brackets, in the format
     * produced by {@link Arrays#toString(Object[])}.
     *
     * @return a string representation of this stack
     */
    @Override
    public synchronized String toString() {
        return Arrays.toString(copyOfRange(stack, 0, size, Object[].class));
    }

    private static int calculateCapacity(final int oldCapacity, final int minCapacity) {
        int newCapacity = (oldCapacity == 0) ? 16 : oldCapacity << 1;
        while (newCapacity < minCapacity && newCapacity > 0)
            newCapacity <<= 1;
        return newCapacity <= 0 ? Integer.MAX_VALUE : newCapacity;
    }

    /**
     * Grows the backing array if necessary to make room for one more element,
     * then inserts {@code element} at {@code index}, shifting any existing
     * elements at or after {@code index} one position toward the top.
     *
     * @param index   the index at which to insert
     * @param element the element to insert
     */
    private void ensureAndInsert(final int index, final E element) {
        if (size + 1 > stack.length) {
            stack = Arrays.copyOf(stack, calculateCapacity(stack.length, size + 1));
        }
        if (index < size)
            arraycopy(stack, index, stack, index + 1, size - index);
        stack[index] = element;
        size++;
    }

    /**
     * Grows the backing array if necessary to make room for all elements of
     * {@code c}, then inserts them starting at {@code index}, shifting any
     * existing elements at or after {@code index} toward the top.
     *
     * @param index the index at which to insert the first new element
     * @param c     the collection of elements to insert
     * @return {@code true} (the stack is always modified when this is called
     *         with a non-empty collection)
     */
    private boolean ensureAndInsertAll(final int index, final Collection<? extends E> c) {
        final int numElements = c.size();
        final Object[] a = c.toArray();

        if (size + numElements > stack.length) {
            stack = Arrays.copyOf(stack, calculateCapacity(stack.length, size + numElements));
        }
        if (index < size)
            arraycopy(stack, index, stack, index + numElements, size - index);
        arraycopy(a, 0, stack, index, numElements);
        size += numElements;
        return true;
    }

    /**
     * Trims the capacity of this stack's backing array to be exactly the
     * stack's current size, releasing any unused storage.
     */
    public synchronized void trimToSize() {
        int oldCapacity = stack.length;
        if (size < oldCapacity)
            stack = (size == 0) ? new Object[0] : Arrays.copyOf(stack, size);
    }

    /**
     * A {@link List} view over a contiguous range of elements in an enclosing
     * {@link CustomStack}. All operations are delegated back to the enclosing
     * stack with indices offset by {@link #fromIndex}, so structural changes
     * made through this view are reflected in the backing stack.
     *
     * @param <E> the type of elements held in the backing stack
     */
    private static class SubStackList<E> extends AbstractList<E> {
        private final CustomStack<E> stack;
        private final int fromIndex;
        private int subSize;

        /**
         * Creates a view over the range {@code [fromIndex, toIndex)} of the
         * given stack.
         *
         * @param stack     the backing stack
         * @param fromIndex the low endpoint (inclusive) of this view, relative to the backing stack
         * @param toIndex   the high endpoint (exclusive) of this view, relative to the backing stack
         */
        public SubStackList(final CustomStack<E> stack, final int fromIndex, final int toIndex) {
            this.stack = stack;
            this.fromIndex = fromIndex;
            this.subSize = toIndex - fromIndex;
        }

        /**
         * Returns the element at the specified position in this view.
         *
         * @param index index of the element to return, relative to this view
         * @return the element at the specified position
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        @Override
        public E get(final int index) {
            checkIndex(index, subSize);
            return stack.get(fromIndex + index);
        }

        /**
         * Replaces the element at the specified position in this view with
         * the specified element.
         *
         * @param index   index of the element to replace, relative to this view
         * @param element element to be stored at the specified position
         * @return the element previously at the specified position
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        @Override
        public E set(final int index, final E element) {
            checkIndex(index, subSize);
            return stack.set(fromIndex + index, element);
        }

        /**
         * Returns the number of elements in this view.
         *
         * @return the number of elements in this view
         */
        @Override
        public int size() {
            return subSize;
        }

        /**
         * Inserts the specified element at the specified position in this
         * view, delegating to the backing stack and growing this view's
         * recorded size.
         *
         * @param index   index at which the element is to be inserted, relative to this view
         * @param element element to be inserted
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        @Override
        public void add(final int index, final E element) {
            if (index < 0 || index > subSize)
                throw new IndexOutOfBoundsException();
            stack.add(fromIndex + index, element);
            subSize++;
        }

        /**
         * Removes the element at the specified position in this view,
         * delegating to the backing stack and shrinking this view's recorded
         * size.
         *
         * @param index the index of the element to be removed, relative to this view
         * @return the element that was removed
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        @Override
        public E remove(final int index) {
            checkIndex(index, subSize);
            E removed = stack.remove(fromIndex + index);
            subSize--;
            return removed;
        }

        /**
         * Returns a view of the portion of this view between the specified
         * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive,
         * relative to this view.
         *
         * @param fromIndex low endpoint (inclusive) of the subList
         * @param toIndex   high endpoint (exclusive) of the subList
         * @return a view of the specified range within this view
         * @throws IndexOutOfBoundsException if the endpoint indices are out of range
         */
        @Override
        public List<E> subList(final int fromIndex, final int toIndex) {
            checkFromToIndex(fromIndex, toIndex, subSize);
            return new SubStackList<>(stack, this.fromIndex + fromIndex, this.fromIndex + toIndex);
        }
    }
}
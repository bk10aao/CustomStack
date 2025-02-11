package org.CustomStack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class CustomStack<T> implements Stack<T> {
    private T[] stack;

    private int stackSize = 32;
    private int insertIndex = 0;
    private int size = 0;

    public CustomStack(int size) {
        stack = (T[]) new Object[size];
        this.stackSize = size;
    }

    public CustomStack() {
        stack = (T[]) new Object[32];
    }

    public boolean isEmpty() {
        return insertIndex == 0;
    }

    public T peek() {
        if (size == 0)
            throw new EmptyStackException();
        return stack[size - 1];
    }

    public T pop() {
        if (size == 0)
            throw new EmptyStackException();
        T item = stack[size - 1];
        stack[--size] = null;
        if(size <= (stackSize / 4))
            reduce();
        insertIndex--;
        return item;
    }

    public T push(final T a) {
        if(insertIndex == stackSize)
            expand();
        stack[insertIndex++] = a;
        return stack[++size - 1];
    }

    public int search(final Object o) {
        if(size == 0) return -1;
        for(int i = size - 1; i >= 0; i--)
            if(stack[i].equals(o))
                return i;
        return -1;
    }

    //These two methods are for testing purposes mainly
    public int getSize() {
        return size;
    }

    public int getStackSize() {
        return stackSize;
    }

    private void expand() {
        stackSize = stackSize * 2;
        T[] newStack = (T[]) new Object[stackSize];
        if (insertIndex >= 0)
            System.arraycopy(stack, 0, newStack, 0, insertIndex);
        stack = newStack;
    }

    private void reduce() {
        stackSize = stackSize / 2;
        T[] newStack = (T[]) new Object[stackSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomStack<?> that = (CustomStack<?>) o;
        return stackSize == that.stackSize && insertIndex == that.insertIndex && size == that.size && Arrays.equals(stack, that.stack);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(stackSize, insertIndex, size) + Arrays.hashCode(stack);
    }

    @Override
    public String toString() {
        if(size == 0)
            return "{ }";
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for(int i = size - 1; i >= 0; i--)
            stringBuilder.append(stack[i]).append(", ");
        return stringBuilder.replace(stringBuilder.lastIndexOf(", "), stringBuilder.length(), " }").toString();
    }
}

package org.CustomStack;

import java.util.EmptyStackException;

public interface Stack<T> {

    /**
     * Return boolean to determine whether Stack is empty
     * @return boolean true if empty else false
     */
    boolean isEmpty();

    /**
     * Get item from top of Stack but does not remove it
     * @return T Item at top of stack
     * @throws EmptyStackException on empty stack
     */
    T peek();

    /**
     * Get item from top of Stack
     * @return T Item at top of stack
     * @throws EmptyStackException on empty stack
     */
    T pop();

    /**
     * Push item into top of Stack
     * @return T Item added to Stack
     */
    T push(T a);

    /**
     * Search for item in Stack
     * @return index of item else, if empty -1.
     */
    int search(Object o);

    /**
     * Return number of items in Stack
     * @return Integer value of number of items in Stack
     */
    int getSize();

    /**
     * Return number of items in Stack including null values
     * @return Integer value of items in Stack including null values
     */
    int getStackSize();
}

package org.CustomStack;

import java.util.EmptyStackException;

public class CustomStack<T> {
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
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T item = stack[size - 1];
        stack[--size] = null;
        if(size <= (stackSize / 4)) {
            reduce();
        }
        insertIndex--;
        return item;
    }

    public T push(T a) {
        if(insertIndex == stackSize) expand();
        stack[insertIndex++] = a;
        return stack[++size - 1];
    }

    public int search(Object o) {
        if(size == 0) return -1;
        for(int i = size - 1; i >= 0; i--)
            if(stack[i] == o) return i;
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
        if (insertIndex >= 0) System.arraycopy(stack, 0, newStack, 0, insertIndex);
        stack = newStack;
    }

    private void reduce() {
        stackSize = stackSize / 2;
        T[] newStack = (T[]) new Object[stackSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }
}

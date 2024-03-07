package org.CustomStack;

import java.util.EmptyStackException;

public class customStack<T> {
    private T[] stack;
    int stackSize = 32;

    int insertIndex = 0;
    int size = 0;


    //Parameterized Constructor
    public customStack(int size) {
        stack = (T[]) new Object[size];
        this.stackSize = size;
    }

    public customStack() {
        stack = (T[]) new Object[32];
    }

    public boolean isEmpty() {
        return insertIndex == 0;
    }

    public T push(T a) {

        if(insertIndex == stackSize) {
            expand();
        }
        stack[insertIndex++] = a;
        size++;
        return stack[size - 1];
    }

    private void expand() {
        stackSize = stackSize * 2;
        T[] newStack = (T[]) new Object[stackSize];
        if (insertIndex >= 0) System.arraycopy(stack, 0, newStack, 0, insertIndex);
        stack = newStack;
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

    private void reduce() {
        stackSize = stackSize / 2;
        T[] newStack = (T[]) new Object[stackSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    public int search(Object o) {
        //TODO: TEST
        if(size == 0) return -1;
        for(int i = size - 1; i >= 0; i--) {
            if(stack[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public int getSize() {
        return size;
    }
}

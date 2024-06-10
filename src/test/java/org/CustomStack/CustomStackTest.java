package org.CustomStack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomStackTest {

    @Test
    public void instantiateDefaultCustomStack_returns_emptyStack() {
        CustomStack<Object> customStack = new CustomStack<>();
        assertTrue(customStack.isEmpty());
    }

    @Test
    public void instantiateCustomStackWithSizeOf_64_returns_emptyStack() {
        CustomStack<Object> customStack = new CustomStack<>(64);
        assertTrue(customStack.isEmpty());
    }

    @Test
    public void pushInteger_10_toDefaultStack_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStack<Object> customStack = new CustomStack<>();
        Object item = 10;
        Object pushedItem =  customStack.push(item);
        assertFalse(customStack.isEmpty());
        assertEquals(pushedItem, item);
        assertEquals(1, customStack.getSize());
    }

    @Test
    public void pushInteger_10_toCustomStackSizeOf_32_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStack<Object> customStack = new CustomStack<>(32);
        Object item = 10;
        Object pushedItem =  customStack.push(item);
        assertFalse(customStack.isEmpty());
        assertEquals(pushedItem, item);
    }

    @Test
    public void pushThreeIntegers__toCustomStackSizeOf_2_returnSizeOf_3_andStackSizeOf_4() {
        CustomStack<Object> customStack = new CustomStack<>(2);
        Object item = 10;
        for(int i = 0; i < 3; i++) {
            customStack.push(item);
        }
        assertFalse(customStack.isEmpty());
        assertEquals(3, customStack.getSize());
        assertEquals(4, customStack.getStackSize());
    }

    @Test
    public void pushFiveIntegers__toCustomStackSizeOf_2_return_size_of_5_andStackSizeOf_8() {
        CustomStack<Object> customStack = new CustomStack<>(2);
        Object item = 10;
        for(int i = 0; i < 5; i++) {
            customStack.push(item);
        }
        assertFalse(customStack.isEmpty());
        assertEquals(5, customStack.getSize());
        assertEquals(8, customStack.getStackSize());
    }

    @Test
    public void popElement_fromEmptyStack_returns_EmptyStackException() {
        CustomStack<Object> customStack = new CustomStack<>();
        assertThrows(EmptyStackException.class, customStack::pop);
    }

    @Test
    public void popElement_fromStack_returns_10() {
        CustomStack<Object> customStack = new CustomStack<>(2);
        Object item = 10;
        customStack.push(item);
        assertEquals(1, customStack.getSize());
        assertFalse(customStack.isEmpty());
        Object result = customStack.pop();
        assertEquals(result, item);
        assertEquals(0, customStack.getSize());
        assertTrue(customStack.isEmpty());
    }

    @Test
    public void peek_onEmptyStack_returns_EmptyStackException() {
        CustomStack<Object> customStack = new CustomStack<>();
        assertThrows(EmptyStackException.class, customStack::peek);
    }

    @Test
    public void peek_onStackOfTreeItems_10_20_30_returns_3() {
        CustomStack<Object> customStack = new CustomStack<>();
        for(int i = 0; i < 3; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        Object expected = 30;
        assertEquals(expected, customStack.peek());
    }

    @Test
    public void pop_onEmptyStack_returns_EmptyStackException() {
        CustomStack<Object> customStack = new CustomStack<>();
        assertThrows(EmptyStackException.class, customStack::pop);
    }

    @Test
    public void popOnDefaultStack_of_10_returns_10_and_sizeOf_0() {
        CustomStack<Object> customStack = new CustomStack<>();
        Object item = 30;
        customStack.push(item);
        assertEquals(item, customStack.pop());
        assertTrue(customStack.isEmpty());
        assertEquals(0, customStack.getSize());
    }

    @Test
    public void popOnDefaultStack_of_10_20_30_returns_30() {
        CustomStack<Object> customStack = new CustomStack<>();
        for(int i = 0; i < 3; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        Object expected = 30;
        assertEquals(expected, customStack.pop());
        assertFalse(customStack.isEmpty());
        assertEquals(2, customStack.getSize());
    }

    @Test
    public void createStackOfSize_8_with_eightItems_whenPopCalled_6_times_returns_stack_size_of_2() {
        CustomStack<Object> customStack = new CustomStack<>(8);
        for(int i = 0; i < 8; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        for(int i = 0; i < 6; i++) {
            customStack.pop();
        }
        Object expected = 20;
        assertFalse(customStack.isEmpty());
        assertEquals(expected, customStack.peek());
        assertEquals(2, customStack.getSize());
        assertEquals(4, customStack.getStackSize());
    }

    @Test
    public void searchEmptyDefaultStack_returns_negative_1() {
        CustomStack<Object> customStack = new CustomStack<>();
        Object doesNotExist = 10;
        assertEquals(-1, customStack.search(doesNotExist));
    }

    @Test
    public void searchStackOfSize_10_with_no_values_returns_negative_1() {
        CustomStack<Object> customStack = new CustomStack<>();
        Object doesNotExist = 10;
        assertEquals(-1, customStack.search(doesNotExist));
    }

    @Test
    public void searchDefaultStack_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStack<Object> customStack = new CustomStack<>();
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        Object doesNotExist = 1_000;
        assertEquals(-1, customStack.search(doesNotExist));
    }

    @Test
    public void searchStackOfSize_10_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStack<Object> customStack = new CustomStack<>(10);
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        Object doesNotExist = 1_000;
        assertEquals(-1, customStack.search(doesNotExist));
    }

    @Test
    public void searchDefaultStack_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStack<Object> customStack = new CustomStack<>(10);
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        Object expected = 30;
        assertEquals(2, customStack.search(expected));
    }

    @Test
    public void searchStackOfSize_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStack<Object> customStack = new CustomStack<>(10);
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            customStack.push(item);
        }
        Object expected = 30;
        assertEquals(2, customStack.search(expected));
    }
}
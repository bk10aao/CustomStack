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
        assertTrue(new CustomStack<>().isEmpty());
    }

    @Test
    public void instantiateCustomStackWithSizeOf_64_returns_emptyStack() {
        assertTrue(new CustomStack<>(64).isEmpty());
    }

    @Test
    public void pushInteger_10_toDefaultStack_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStack<Integer> customStack = new CustomStack<>();
        int pushedItem =  customStack.push(10);
        assertFalse(customStack.isEmpty());
        assertEquals(pushedItem, 10);
        assertEquals(1, customStack.getSize());
    }

    @Test
    public void pushInteger_10_toCustomStackSizeOf_32_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStack<Integer> customStack = new CustomStack<>(32);
        int pushedItem =  customStack.push(10);
        assertFalse(customStack.isEmpty());
        assertEquals(10, pushedItem);
    }

    @Test
    public void pushThreeIntegers__toCustomStackSizeOf_2_returnSizeOf_3_andStackSizeOf_4() {
        CustomStack<Integer> customStack = new CustomStack<>(2);
        for(int i = 0; i < 3; i++)
            customStack.push(10);
        assertFalse(customStack.isEmpty());
        assertEquals(3, customStack.getSize());
        assertEquals(4, customStack.getStackSize());
    }

    @Test
    public void pushFiveIntegers__toCustomStackSizeOf_2_return_size_of_5_andStackSizeOf_8() {
        CustomStack<Integer> customStack = new CustomStack<>(2);
        for(int i = 0; i < 5; i++)
            customStack.push(10);
        assertFalse(customStack.isEmpty());
        assertEquals(5, customStack.getSize());
        assertEquals(8, customStack.getStackSize());
    }

    @Test
    public void popElement_fromEmptyStack_returns_EmptyStackException() {
        assertThrows(EmptyStackException.class, new CustomStack<>()::pop);
    }

    @Test
    public void popElement_fromStack_returns_10() {
        CustomStack<Integer> customStack = new CustomStack<>(2);
        customStack.push(10);
        assertEquals(1, customStack.getSize());
        assertFalse(customStack.isEmpty());
        Integer result = customStack.pop();
        assertEquals(result, 10);
        assertEquals(0, customStack.getSize());
        assertTrue(customStack.isEmpty());
    }

    @Test
    public void peek_onEmptyStack_returns_EmptyStackException() {
        assertThrows(EmptyStackException.class, new CustomStack<>()::peek);
    }

    @Test
    public void peek_onStackOfTreeItems_10_20_30_returns_3() {
        CustomStack<Integer> customStack = new CustomStack<>();
        for(int i = 0; i < 3; i++)
            customStack.push((i + 1) * 10);
        assertEquals(30, customStack.peek());
    }

    @Test
    public void pop_onEmptyStack_returns_EmptyStackException() {
        assertThrows(EmptyStackException.class, new CustomStack<>()::pop);
    }

    @Test
    public void popOnDefaultStack_of_10_returns_10_and_sizeOf_0() {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(10);
        assertEquals(10, customStack.pop());
        assertTrue(customStack.isEmpty());
        assertEquals(0, customStack.getSize());
    }

    @Test
    public void popOnDefaultStack_of_10_20_30_returns_30() {
        CustomStack<Integer> customStack = new CustomStack<>();
        for(int i = 0; i < 3; i++)
            customStack.push((i + 1) * 10);
        assertEquals(30, customStack.pop());
        assertFalse(customStack.isEmpty());
        assertEquals(2, customStack.getSize());
    }

    @Test
    public void createStackOfSize_8_with_eightItems_whenPopCalled_6_times_returns_stack_size_of_2() {
        CustomStack<Integer> customStack = new CustomStack<>(8);
        for(int i = 0; i < 8; i++)
            customStack.push((i + 1) * 10);
        for(int i = 0; i < 6; i++)
            customStack.pop();
        assertFalse(customStack.isEmpty());
        assertEquals(20, customStack.peek());
        assertEquals(2, customStack.getSize());
        assertEquals(4, customStack.getStackSize());
    }

    @Test
    public void searchEmptyDefaultStack_returns_negative_1() {
        CustomStack<Integer> customStack = new CustomStack<>();
        assertEquals(-1, customStack.search(10));
    }

    @Test
    public void searchStackOfSize_10_with_no_values_returns_negative_1() {
        CustomStack<Integer> customStack = new CustomStack<>();
        assertEquals(-1, customStack.search(10));
    }

    @Test
    public void searchDefaultStack_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStack<Integer> customStack = new CustomStack<>();
        for(int i = 0; i < 10; i++)
            customStack.push((i + 1) * 10);
        assertEquals(-1, customStack.search(1_000));
    }

    @Test
    public void searchStackOfSize_10_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStack<Integer> customStack = new CustomStack<>(10);
        for(int i = 0; i < 10; i++)
            customStack.push((i + 1) * 10);
        assertEquals(-1, customStack.search(1_000));
    }

    @Test
    public void searchDefaultStack_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStack<Integer> customStack = new CustomStack<>(10);
        for(int i = 0; i < 10; i++)
            customStack.push((i + 1) * 10);
        assertEquals(2, customStack.search(30));
    }

    @Test
    public void searchStackOfSize_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStack<Integer> customStack = new CustomStack<>(10);
        for(int i = 0; i < 10; i++)
            customStack.push((i + 1) * 10);
        assertEquals(2, customStack.search(30));
    }

    @Test
    public void givenStackOfValues__0_10_20_30_40_returnsCorrectString_on_toString() {
        CustomStack<Integer> customStack = new CustomStack<>(10);
        for(int i = 0; i < 5; i++)
            customStack.push(i * 10);
        assertEquals("{ 40, 30, 20, 10, 0 }", customStack.toString());
    }

    @Test
    public void givenEmptyStack_on_toString_returns_emptyCurlyBraces() {
        assertEquals("{ }", new CustomStack<>(10).toString());
    }
}
package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {


    private MinMaxStack stack;

    @BeforeEach
    void setUp() {
        stack = new MinMaxStackImpl();
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void stackIsNotEmptyAfterPush() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void peekReturnsLastPushedElement() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    @Test
    void getMinAndMaxWithOneElement() {
        stack.push(10);
        assertEquals(10, stack.getMin());
        assertEquals(10, stack.getMax());
    }

}
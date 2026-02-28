package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {


    private static final int FIRST_VALUE = 5;
    private static final int LOWER_VALUE = 3;
    private static final int HIGHER_VALUE = 10;
    private static final int ANOTHER_VALUE = 20;
    private static final int ONE_ELEMENT = 1;

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
        stack.push(HIGHER_VALUE);

        assertFalse(stack.isEmpty());
        assertEquals(ONE_ELEMENT, stack.size());
    }

    @Test
    void peekReturnsLastPushedElement() {
        stack.push(HIGHER_VALUE);
        stack.push(ANOTHER_VALUE);

        assertEquals(ANOTHER_VALUE, stack.peek());
    }

    @Test
    void getMinAndMaxWithOneElement() {
        stack.push(HIGHER_VALUE);

        assertEquals(HIGHER_VALUE, stack.getMin());
        assertEquals(HIGHER_VALUE, stack.getMax());
    }

    @Test
    void popRemovesAndReturnsLastElement() {
        stack.push(FIRST_VALUE);

        int value = stack.pop();

        assertEquals(FIRST_VALUE, value);
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushAndPopMaintainCorrectMinAndMax() {
        stack.push(FIRST_VALUE);
        stack.push(LOWER_VALUE);
        stack.push(HIGHER_VALUE);

        assertEquals(HIGHER_VALUE, stack.getMax());
        assertEquals(LOWER_VALUE, stack.getMin());
        assertEquals(HIGHER_VALUE, stack.peek());

        assertEquals(HIGHER_VALUE, stack.pop());

        assertEquals(FIRST_VALUE, stack.getMax());
        assertEquals(LOWER_VALUE, stack.getMin());
        assertEquals(LOWER_VALUE, stack.peek());
    }
}

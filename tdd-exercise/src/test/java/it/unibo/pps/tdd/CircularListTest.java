package it.unibo.pps.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularListTest {


    private CircularQueue  queue;
    @BeforeEach
    void setUp() {
        queue = new CircularQueueImpl(5);
    }


    @Test
    void testInitialState() {
        assertEquals(0, queue.size());
        assertEquals(5, queue.capacity());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testNewQueueIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueueIncrementsSize() {
        int value = 10;
        queue.enqueue(value);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void testPeekReturnsFirstElement() {
        int value = 10;
        queue.enqueue(value);
        assertEquals(Optional.of(value), queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void testDequeueRemovesElement() {
        int value = 10;
        int value2 = 20;
        queue.enqueue(value);
        queue.enqueue(value2);
        assertEquals(Optional.of(value), queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(Optional.of(value2), queue.peek());
    }

    @Test
    void testEnqueueOnFullQueueOverwritesOldest() {

        CircularQueue queue = new CircularQueueImpl(3);

        queue.enqueue(10); // Position 0
        queue.enqueue(20); // Position 1
        queue.enqueue(30); // Position 2 -> Full queue

        queue.enqueue(40); // rewrite over 10

        assertEquals(3, queue.size()); // retesting size

        assertEquals(Optional.of(20), queue.peek()); // peek test

        assertEquals(Optional.of(20), queue.dequeue());
        assertEquals(Optional.of(30), queue.dequeue());
        assertEquals(Optional.of(40), queue.dequeue());

        assertTrue(queue.isEmpty());
    }

}

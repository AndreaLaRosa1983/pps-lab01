package it.unibo.pps.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularListTest {


    @Test
    void testInitialState() {
        CircularQueue queue = new CircularQueueImpl(5);
        assertEquals(0, queue.size());
        assertEquals(5, queue.capacity());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testNewQueueIsEmpty() {
        CircularQueue queue = new CircularQueueImpl(5);
        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueueIncrementsSize() {
        CircularQueue queue = new CircularQueueImpl(5);
        queue.enqueue(10);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void testEnqueue


}

package it.unibo.pps.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularQueueTest {
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


}

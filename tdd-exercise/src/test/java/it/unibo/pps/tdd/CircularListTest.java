package it.unibo.pps.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularQueueTest {
    @Test
    void testNewQueueIsEmpty() {
        CircularQueue queue = newCircularQueueImpl(5);
        assertTrue(queue.isEmpty());
    }
}

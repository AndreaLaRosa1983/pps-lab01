package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class SmartDoorLockTest {

    private SmartDoorLock lock;
    private int pin;

    @BeforeEach
    void setUp() {
        lock = new SmartDoorLockImpl();
        pin = 1234;
    }

    @Test
    void isLocked() {
        lock.setPin(pin);
        lock.lock();
        assertTrue(lock.isLocked());
    }

    @Test
    void testLockWithoutPin() {
        assertThrows(IllegalStateException.class, lock::lock);
    }

    @Test
    void testSetPinNotAllowedWhenLocked() {
        lock.setPin(pin);
        lock.lock();

        assertThrows(IllegalStateException.class, () -> lock.setPin(9999));

        lock.unlock(9999);
        assertTrue(lock.isLocked());

        lock.unlock(pin);
        assertFalse(lock.isLocked());
    }

    @Test
    void testSetPinNotAllowedWhenBlocked() {
        int wrongPin = 2;
        lock.setPin(pin);

        lock.unlock(wrongPin);
        lock.unlock(wrongPin);
        lock.unlock(wrongPin);

        assertTrue(lock.isBlocked());
        assertThrows(IllegalStateException.class, () -> lock.setPin(9999));
    }

    @Test
    void isBlocked() {
        int wrongPin = 2345;
        lock.setPin(pin);

        lock.unlock(wrongPin);
        lock.unlock(wrongPin);
        lock.unlock(wrongPin);

        assertTrue(lock.isBlocked());
    }

    @Test
    void testGetExpectedAttempts() {
        int wrongPin = 2345;
        int attempts = 2;
        lock.setPin(pin);

        lock.unlock(wrongPin);
        lock.unlock(wrongPin);

        assertEquals(attempts, lock.getFailedAttempts());
    }

    @Test
    void testGetMaxAttempts() {
        int attempts = 3;
        assertEquals(attempts, lock.getMaxAttempts());
    }

    @Test
    void testReset() {
        int wrongPin = 2345;
        lock.setPin(pin);

        lock.unlock(wrongPin);
        lock.unlock(wrongPin);
        lock.unlock(wrongPin);

        assertTrue(lock.isBlocked());
        assertEquals(3, lock.getFailedAttempts());

        lock.reset();

        assertFalse(lock.isBlocked());
        assertEquals(0, lock.getFailedAttempts());
    }
}
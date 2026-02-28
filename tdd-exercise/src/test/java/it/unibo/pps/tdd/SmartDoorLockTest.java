package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock lock;
    private int pin;
    @BeforeEach
    void beforeEach(){
       lock = new SmartDoorLockImpl();
       pin = 1234;
    }

    @Test
    public void isLocked() {
        lock.setPin(pin);
        lock.lock();
        assertTrue(lock.isLocked());
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
    void getExpectedAttempts(){
        int wrongPin = 2345 ;
        int attempts = 2;
        lock.setPin(pin);
        lock.unlock(wrongPin);
        lock.unlock(wrongPin);
        assertEquals(attempts,lock.getFailedAttempts());
    }

    @Test
    void getMaxAttempts(){
        int attempts = 3;
        assertEquals(attempts,lock.getMaxAttempts());
    }
}

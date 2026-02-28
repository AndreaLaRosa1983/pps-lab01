package it.unibo.pps.tdd;

import java.util.Objects;
import java.util.OptionalInt;

public class SmartDoorLockImpl implements SmartDoorLock {

    private Integer pin;
    private boolean lock;
    private int maxAttempts = 3;
    private int attempts = 0;
    @Override
    public void setPin(int pin) {
        if (pin < 0 || pin > 9999) return;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == null || isBlocked()) return;
        if (this.pin == pin) {
            lock = false;
        } else {
            attempts +=1;
        }
    }

    @Override
    public void lock() {
        if (pin == null) return;
        this.lock = true;
    }

    @Override
    public boolean isLocked() {
        return this.lock;
    }

    @Override
    public boolean isBlocked() {
        return maxAttempts == attempts;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return this.attempts;
    }

    @Override
    public void reset() {
    }
}

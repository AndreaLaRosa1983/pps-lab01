package it.unibo.pps.tdd;

import java.util.Objects;
import java.util.OptionalInt;

public class SmartDoorLockImpl implements SmartDoorLock {

    private Integer pin;
    private boolean lock;
    private boolean block;
    @Override
    public void setPin(int pin) {
        if (pin < 0 || pin > 9999) return;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {

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
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}

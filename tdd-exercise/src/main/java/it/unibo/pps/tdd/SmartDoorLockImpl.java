package it.unibo.pps.tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private Integer pin;
    private boolean locked;
    private final int maxAttempts = 3;
    private int attempts;

    @Override
    public void setPin(int pin) {
        if (isLocked() || isBlocked()) {
            throw new IllegalStateException("Cannot set PIN when locked or blocked.");
        }
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == null || isBlocked()) {
            return;
        }
        if (this.pin == pin) {
            locked = false;
        } else {
            attempts++;
        }
    }

    @Override
    public void lock() {
        if (pin == null) {
            throw new IllegalStateException("Cannot lock: PIN not set.");
        }
        locked = true;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public boolean isBlocked() {
        return attempts >= maxAttempts;
    }

    @Override
    public int getMaxAttempts() {
        return maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return attempts;
    }

    @Override
    public void reset() {
        pin = null;
        locked = false;
        attempts = 0;
    }
}
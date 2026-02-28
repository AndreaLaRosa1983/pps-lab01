package it.unibo.pps.tdd;

public class CircularQueueImpl implements CircularQueue {

    private final int capacity;
    private int size;

    public CircularQueueImpl(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0 ;
    }
}

package it.unibo.pps.tdd;

import java.util.Optional;

public class CircularQueueImpl implements CircularQueue {

    private final int capacity;
    private int size = 0;
    private int readIndex = 0;
    private int writeIndex = 0;
    private final int[] queue;

    public CircularQueueImpl(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
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
    public void enqueue(int value) {
        queue[writeIndex] = value;
        writeIndex = (writeIndex + 1) % this.capacity;
        if (size < capacity){
            this.size++;
        } else {
            this.readIndex = (this.readIndex + 1) % this.capacity;
        }


    }

    @Override
    public Optional<Integer> dequeue() {
        return Optional.empty();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0 ;
    }
}

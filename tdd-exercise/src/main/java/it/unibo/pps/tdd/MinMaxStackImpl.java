package it.unibo.pps.tdd;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class MinMaxStackImpl implements MinMaxStack {


    private final Deque<Integer> stack = new ArrayDeque<>();


    @Override
    public void push(int value) {
        stack.addFirst(value);
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}

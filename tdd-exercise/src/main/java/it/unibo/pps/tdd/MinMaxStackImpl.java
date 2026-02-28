package it.unibo.pps.tdd;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class MinMaxStackImpl implements MinMaxStack {

    private final Deque<Integer> mainStack = new ArrayDeque<>();
    private final Deque<Integer> maxStack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    @Override
    public void push(int value) {
        mainStack.addFirst(value);

        if(minStack.isEmpty() && maxStack.isEmpty()){

            maxStack.addFirst(value);
            minStack.addFirst(value);
        } else {
            maxStack.addFirst(Math.max(value,maxStack.peek()));
            minStack.addFirst(Math.min(value,minStack.peek()));
        }
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Lo stack è vuoto");
        }
        return mainStack.peek();
    }
    @Override
    public int getMin() {
        if (isEmpty()) throw new IllegalStateException();
        return minStack.peek();
    }

    @Override
    public int getMax() {
        return maxStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    @Override
    public int size() {
        return mainStack.size();
    }
}

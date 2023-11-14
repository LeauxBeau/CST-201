/**
 * 
 */
package app;

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(T v) {
        stack.add(v);
    }

    public int size() {
        return stack.size();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public T top() {
        if (!empty()) {
            return stack.get(size() - 1);
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public void pop() {
        if (!empty()) {
            stack.remove(size() - 1);
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }
}


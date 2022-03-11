package com.bobo.offer;

import java.util.Objects;
import java.util.Stack;

/**
 * @Description 剑指 Offer 30. 包含min函数的栈
 * @Date 2022/3/11 10:37 PM
 * @Created by bobo
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> s;
    Stack<Integer> minStack;

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = s.pop();
        if (Objects.equals(pop, minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

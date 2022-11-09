package com.bobo.leetcode232;

import java.util.Stack;

/**
 * @author by bobo
 * @Description 队列
 * @Date 2022/11/7 09:56
 */
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        int result = pop();
        stack2.push(result);
        return result;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
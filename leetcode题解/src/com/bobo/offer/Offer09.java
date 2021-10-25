package com.bobo.offer;

import java.util.Stack;

/**
 * @Description 剑指offer第9题
 * @Date 2022/3/9 10:15 PM
 * @Created by bobo
 */
public class Offer09 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public Offer09() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s1.isEmpty()){
            return -1;
        }
        while (!s1.isEmpty()) {
            Integer pop = s1.pop();
            s2.push(pop);
        }
        Integer result = s2.pop();
        while (!s2.isEmpty()) {
            Integer pop = s2.pop();
            s1.push(pop);
        }
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.pop();
    }
}

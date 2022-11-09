package com.bobo.leetcode232;

import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode232 用栈实现队列
 * @Date 2022/11/5 21:27
 */
public class Solution {


    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

package com.bobo.leetcode739;

import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode 739 每日温度
 * @Date 2022/10/25 09:51
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = new Solution().dailyTemperatures(nums);

    }
}

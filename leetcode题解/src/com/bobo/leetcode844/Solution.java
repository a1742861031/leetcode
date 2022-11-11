package com.bobo.leetcode844;

import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode844 比较含退格的字符串
 * @Date 2022/11/11 09:19
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(t.charAt(i));
            }
        }
        return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        boolean b = new Solution().backspaceCompare("a#c", "b");
        System.out.println(b);
    }
}

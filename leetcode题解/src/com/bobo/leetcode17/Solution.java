package com.bobo.leetcode17;

import java.util.*;

/**
 * @author by bobo
 * @Description leetcode17 电话号码的字母组合
 * @Date 2022/9/18 10:09
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (Objects.equals(digits, "")) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            strs.add(map.get(digits.charAt(i)));
        }
        List<String> ans = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backTracking(digits, ans, stack, strs, 0);
        return ans;
    }

    public void backTracking(String digits, List<String> ans, Stack<Character> stack, List<String> strs, int index) {
        if (stack.size() == digits.length()) {
            StringBuilder cur = new StringBuilder();
            for (Character character : stack) {
                cur.append(character);
            }
            ans.add(cur.toString());
            return;
        }
        String s = strs.get(index);
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            backTracking(digits, ans, stack, strs, index + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));

    }
}

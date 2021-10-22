package com.bobo.leetcode03;

import java.util.HashMap;

/**
 * @Description 无重复字符的最长子串
 * @Date 2021/10/22 19:13
 * @Created by bobo
 */
public class Leetcode03 {
    public static void main(String[] args) {
        Leetcode03 leetcode03 = new Leetcode03();
        int result = leetcode03.lengthOfLongestSubstring("abba");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                end = i;
            } else {
                result = Math.max(result, end - start + 1);
                start = Math.max(map.get(s.charAt(i)) + 1, start);
                map.put(s.charAt(i), i);
                end = i;
            }
        }
        result = Math.max(result, end - start + 1);
        return result;
    }
}

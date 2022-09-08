package com.bobo.leetcode567;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode 567 字符串的排列
 * @Date 2022/9/6 12:09 PM
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        boolean ans = false;
        for (int i = 0; i < s1.length(); i++) {
            if (count1.containsKey(s1.charAt(i))) {
                count1.put(s1.charAt(i), count1.get(s1.charAt(i)) + 1);
            } else {
                count1.put(s1.charAt(i), 1);
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (count2.containsKey(s2.charAt(i))) {
                count2.put(s2.charAt(i), count2.get(s2.charAt(i)) + 1);
            } else {
                count2.put(s2.charAt(i), 1);
            }
        }
        if (count1.equals(count2)) {
            return true;
        }
        int start = 0, end = s1.length() - 1;
        while (end < s2.length() - 1) {
            if (count1.equals(count2)) {
                return true;
            }
            end++;
            if (count2.get(s2.charAt(start)) == 1) {
                count2.remove(s2.charAt(start));
            } else {
                count2.put(s2.charAt(start), count2.get(s2.charAt(start)) - 1);
            }
            if (count2.containsKey(s2.charAt(end))) {
                count2.put(s2.charAt(end), count2.get(s2.charAt(end)) + 1);
            } else {
                count2.put(s2.charAt(end), 1);
            }
            start++;
            if (count1.equals(count2)) {
                return true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("adc", "dcda"));
    }
}

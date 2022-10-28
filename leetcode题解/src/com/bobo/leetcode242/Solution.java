package com.bobo.leetcode242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description 有效的字母异位词
 * @Date 2022/10/26 10:31
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {

            Integer count = map.get(t.charAt(i));
            if (count == null || count < 1) {
                return false;
            } else {
                map.put(t.charAt(i), count - 1);
            }
        }
        for (Character character : map.keySet()) {
            Integer count = map.get(character);
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean anagram = new Solution().isAnagram("rat", "car");
        System.out.println(anagram);
    }
}

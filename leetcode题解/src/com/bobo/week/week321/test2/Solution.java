package com.bobo.week.week321.test2;

/**
 * @author by bobo
 * @Description
 * @Date 2022/11/27 11:28
 */
public class Solution {
    public int appendCharacters(String s, String t) {
        int point = 0;
        int length = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            while (point < s.length()) {
                if (s.charAt(point) == c) {
                    length++;
                    point++;
                    break;
                }
                point++;
            }
        }
        return t.length()-length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().appendCharacters("abcde","a"));
    }
}


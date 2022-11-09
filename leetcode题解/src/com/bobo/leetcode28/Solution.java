package com.bobo.leetcode28;

/**
 * @author by bobo
 * @Description leetcode28 找出字符串中第一个不匹配的下标
 * @Date 2022/11/4 09:01
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        //进行字符串匹配
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == (needle.length()-1)) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public int[] getNext(String s) {
        int length = s.length();
        int[] next = new int[length];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "adbu"));

    }
}

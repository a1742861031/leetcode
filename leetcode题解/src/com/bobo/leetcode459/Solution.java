package com.bobo.leetcode459;

/**
 * @author by bobo
 * @Description leetcode459 重复的子字符串
 * @Date 2022/11/3 09:21
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        int i = 2;
        while (length / i >= 1) {
            if (length % i == 0) {
                int subLen = length / i;
                String substring = s.substring(0, length / i);
                int j = subLen;
                for (; j < s.length(); j += subLen) {
                    String substring1 = s.substring(j, j + subLen);
                    if (!substring.equals(substring1)) {
                        break;
                    }
                }
                if(j>=length){
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(new Solution().repeatedSubstringPattern(s));
    }
}

package com.bobo.leetcode541;

/**
 * @author by bobo
 * @Description leetcode 541. 反转字符串 II
 * @Date 2022/10/28 10:16
 */
public class Solution {

    public String reverseStr(String s, int k) {
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;
        for (; j <= s.length(); i++, j += 2) {
            if (j != 0 && j % (2 * k) == 0) {
                String reverse = reverse(s.substring(j - 2 * k, j), 0, k);
                str.append(reverse);
            }
        }
        String reverse;
        String subStr = s.substring(str.length());
        if (subStr.length()>k) {
            reverse = reverse(subStr, 0, k);
        } else {
            reverse = reverse(subStr ,0, subStr.length());
        }
        str.append(reverse);
        return str.toString();
    }

    /**
     * 翻转字符串的指定区间
     */
    public String reverse(String s, int beginIndex, int endIndex) {
        StringBuilder str = new StringBuilder();
        str.append(s, 0, beginIndex);
        for (int i = endIndex - 1; i >= beginIndex; i--) {
            str.append(s.charAt(i));
        }
        str.append(s.substring(endIndex));
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(new Solution().reverseStr(s, 2));
    }
}

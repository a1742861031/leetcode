package com.bobo.leetcode05;

/**
 * @Description 最长回文子串
 * @Date 2021/10/25 11:47
 * @Created by bobo
 */
public class LeetCode05 {
    public static void main(String[] args) {
        LeetCode05 leetCode05 = new LeetCode05();
        System.out.println(leetCode05.longestPalindrome(" "));
    }
    //这种方法是的时间复杂度为n的三次方，超时
    public String longestPalindrome(String s) {
        String res = "";
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                temp.append(s.charAt(j));
                if (judgePalindrome(temp) && temp.length() > res.length()) {
                    res = temp.toString();
                }
            }
            temp = new StringBuilder();
        }
        return res;
    }

    public boolean judgePalindrome(StringBuilder s) { //判断是否为回文字符串
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

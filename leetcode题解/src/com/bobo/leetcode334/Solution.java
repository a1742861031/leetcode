package com.bobo.leetcode334;

/**
 * @author by bobo
 * @Description 反转字符串
 * @Date 2022/9/3 10:51 AM
 */
public class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(arr);
        for (char c : arr) {
            System.out.println(c);
        }
    }

}

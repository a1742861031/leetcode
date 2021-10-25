package com.bobo.leetcode05;

/**
 * @Description 方法2 使用动态规划
 * @Date 2021/10/25 14:21
 * @Created by bobo
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 method2 = new Solution2();
        String s = method2.longestPalindrome("abcda");
        System.out.println(s);
    }

    /**
     * 回文串具有天生的状态转移特性：当一个回文串取掉两头后，仍是一个回文串
     * 以i作为该字符串的左边界，j作为右边界
     * dp[i][j]表示该s[i,j]是否为回文串
     * 状态转移方程为dp[i][j] = dp[i-1][j+1]&&s[i]==s[j]
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        //使用dp[i][j]表示子串s[i..j是否为回文子串]
        int l = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[l][l];
        for (int k = 0; k < l; k++) {
            dp[k][k] = true;
        }
        for (int j = 1; j < l; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

package com.bobo.leetcode516;

/**
 * @author by bobo
 * @Description leetcode516 最长回文子序列
 * @Date 2022/10/25 09:26
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int ans = 0;
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (ans < dp[i][j]) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution().longestPalindromeSubseq(s));
    }
}

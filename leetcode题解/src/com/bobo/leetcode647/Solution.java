package com.bobo.leetcode647;

/**
 * @author by bobo
 * @Description leetcode 647 回文子串
 * @Date 2022/10/24 10:08
 */
public class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (Math.abs(i - j) <= 1) {
                        ans++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaaaa"));
    }
}

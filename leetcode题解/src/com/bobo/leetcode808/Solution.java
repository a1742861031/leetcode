package com.bobo.leetcode808;

/**
 * @author by bobo
 * @Description leetcode808 分汤
 * @Date 2022/11/21 09:55
 */
public class Solution {
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i < dp.length; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)] + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]) / 4.0;

            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double v = solution.soupServings(100);
        System.out.println(v);
    }
}

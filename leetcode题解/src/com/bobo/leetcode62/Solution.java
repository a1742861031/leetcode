package com.bobo.leetcode62;

/**
 * @author by bobo
 * @Description leetcode62 不同路径
 * @Date 2022/10/5 10:18
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        if (m == 1 || n == 1) {
            return 1;
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j <= 1) {
                    continue;
                }
                if (i >= 1 && j >= 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}

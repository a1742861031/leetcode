package com.bobo.leetcode63;

/**
 * @author by bobo
 * @Description 63. 不同路径 II
 * @Date 2022/10/5 10:40
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        if (m == 1 || n == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        dp[0][0] = 1;
        if (obstacleGrid[0][1] != 1) {
            dp[0][1] = 1;
        }
        if (obstacleGrid[1][0] != 1) {
            dp[1][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
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
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}

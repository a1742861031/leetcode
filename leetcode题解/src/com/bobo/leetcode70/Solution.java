package com.bobo.leetcode70;

/**
 * @author by bobo
 * @Description leetcode70 爬楼梯
 * @Date 2022/10/4 10:14
 */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}

package com.bobo.leetcode343;

/**
 * @author by bobo
 * @Description leetcode343 整数拆分
 * @Date 2022/10/6 09:23
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                //直接拆分成两个数
                //与拆分成多个数相比较取大
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2));
    }
}

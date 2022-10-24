package com.bobo.leetcode746;

/**
 * @author by bobo
 * @Description leetcode 746 使用最小花费爬楼梯
 * @Date 2022/10/5 09:31
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        if (n < 2) {
            return 0;
        }
        //初始化
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }
}

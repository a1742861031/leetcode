package com.bobo.leetcode322;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description 零钱兑换
 * @Date 2022/10/18 09:35
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //先遍历物品，再遍历背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new Solution().coinChange(coins, 11));
    }
}

package com.bobo.leetcode518;

/**
 * @author by bobo
 * @Description 力扣题目链接
 * @Date 2022/10/17 09:53
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //先遍历物品，再遍历背包 这种求的是排列数 而不是组合数
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new Solution().change(5, coins));
    }
}

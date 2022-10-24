package com.bobo.bag01;

/**
 * @author by bobo
 * @Description 01背包问题
 * @Date 2022/10/6 10:54
 */
public class Solution {
    /**
     * @param weight    物品i重量为weight[i]
     * @param value     物品i价值为value[i]
     * @param bagWeight 背包的最大容量
     */
    public void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int[][] dp = new int[weight.length][bagWeight + 1];
        int length = weight.length;
        for (int i = weight[0]; i <= bagWeight; i++) {
            dp[0][i] = value[0];
        }
        //先遍历物品再遍历背包
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                //当超出了背包容量
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        new Solution().testWeightBagProblem(weight, value, bagWeight);
    }
}

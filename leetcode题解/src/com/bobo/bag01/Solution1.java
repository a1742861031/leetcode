package com.bobo.bag01;

/**
 * @author by bobo
 * @Description 01背包问题  一维dp数组
 * @Date 2022/10/9 10:26
 */
public class Solution1 {
    public void dp(int[] weights, int[] values, int maxBag) {
        int[] dp = new int[maxBag + 1];
        dp[0] = 0;
        //先遍历物品
        for (int i = 0; i < weights.length; i++) {
            //再倒序遍历背包
            //背包容量一定与要大于物品重量
            for (int j = maxBag; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{15, 20, 30};
        int[] weights = new int[]{1, 3, 4};
        int maxBag = 4;
        Solution1 solution1 = new Solution1();
        solution1.dp(weights, values, maxBag);
    }
}

package com.bobo.leetcode1049;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode1049 最后一台石头的重量
 * @Date 2022/10/10 18:12
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        //初始化dp数组
        int sum = Arrays.stream(stones).sum();
        int[] dp = new int[sum / 2 + 1];
        //先遍历物品，再遍历背包
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //sum-dp[sum/2]表示一堆
        //dp[sum/2]表示另一堆
        return sum - dp[sum / 2] - dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{31, 26, 33, 21, 40};
        int ans = new Solution().lastStoneWeightII(arr);
        System.out.println(ans);
    }
}

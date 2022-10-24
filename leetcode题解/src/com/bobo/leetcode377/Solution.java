package com.bobo.leetcode377;

/**
 * @author by bobo
 * @Description leetcode 377 组合总和
 * @Date 2022/10/17 10:37
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        //dp数组初始化
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //先遍历背包，在遍历物品
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution().combinationSum4(nums, 4));
    }
}

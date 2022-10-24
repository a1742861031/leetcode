package com.bobo.leetcode494;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode 494 目标和
 * @Date 2022/10/11 10:06
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //总和
        int sum = Arrays.stream(nums).sum();
        //目标和是奇数时，找不到
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        if (target + sum < 0) {
            return 0;
        }
        int find = (target + sum) / 2;
        int[] dp = new int[find + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = find; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[find];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }
}

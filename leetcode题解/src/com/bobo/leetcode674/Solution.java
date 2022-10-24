package com.bobo.leetcode674;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode 674 最长连续递增序列
 * @Date 2022/10/21 12:07
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i + 1] = dp[i] + 1;
            }
        }
        Arrays.sort(dp);
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(new Solution().findLengthOfLCIS(nums));
    }
}

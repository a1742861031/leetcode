package com.bobo.leetcode53;

/**
 * @author by bobo
 * @Description leet53 最大子数组和
 * @Date 2022/9/1 12:13 PM
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        for (int j : dp) {
            if (ans < j) {
                ans = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(arr));
    }
}

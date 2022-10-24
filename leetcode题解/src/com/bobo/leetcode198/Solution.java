package com.bobo.leetcode198;

/**
 * @author by bobo
 * @Description 打家劫舍
 * @Date 2022/10/20 10:18
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] beginNums = new int[nums.length - 1];
        int[] endNums = new int[nums.length - 1];
        System.arraycopy(nums, 0, beginNums, 0, beginNums.length);
        System.arraycopy(nums, 1, endNums, 0, endNums.length);
        int ans1 = robSolution(beginNums);
        int ans2 = robSolution(endNums);
        return Math.max(ans1, ans2);
    }

    public int robSolution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};
        int rob = new Solution().rob(nums);
        System.out.println(rob);
    }
}

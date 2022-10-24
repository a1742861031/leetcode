package com.bobo.leetcode416;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode 416 分割等和子集
 * @Date 2022/10/9 10:37
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        //初始化dp数组
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean b = new Solution().canPartition(nums);
        System.out.println(b);
    }
}

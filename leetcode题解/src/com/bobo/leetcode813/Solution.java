package com.bobo.leetcode813;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode 813 最大平均值和分组
 * @Date 2022/11/28 09:51
 */
public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        Arrays.sort(nums);
        double ans = 0;
        int sum = 0;
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            ans += nums[i];
        }
        for (int i = 0; i <= nums.length - k; i++) {
            sum += nums[i];
        }
        double avg = sum / 1.0 / (nums.length - k + 1);
        ans += avg;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};

        System.out.println(new Solution().largestSumOfAverages(nums, 4));
    }
}

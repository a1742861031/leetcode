package com.bobo.leetcode795;

/**
 * @author by bobo
 * @Description leetcode795 区间子数组个数
 * @Date 2022/11/24 10:12
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int point1 = -1;
        int point2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                point1 = i;
            } else if (nums[i] > right) {
                point1 = -1;
                point2 = i;
            }
            if (point1 != -1) {
                ans += (point1 - point2);
            }
        }
        return ans;
    }

    private int count(int i) {
        int ans = 0;
        for (int j = 1; j <= i; j++) {
            ans += j;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 4, 3};
        int i = new Solution().numSubarrayBoundedMax(nums, 2, 3);
        System.out.println(i);
    }
}

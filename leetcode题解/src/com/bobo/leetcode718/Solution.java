package com.bobo.leetcode718;

/**
 * @author by bobo
 * @Description leetcode 718 最长重复子数组
 * @Date 2022/10/22 09:30
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i <= nums1.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= nums2.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (dp[i][j] > ans) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        int length = new Solution().findLength(nums1, nums2);
        System.out.println(length);
    }
}

package com.bobo.leetcode1035;

/**
 * @author by bob
 * @Description leetcode 1035 不相交的线
 * @Date 2022/10/24 09:21
 */
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //其实这道题就是求最长公共子序列的长度
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 5, 1, 2, 5};
        int[] nums2 = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(new Solution().maxUncrossedLines(nums1, nums2));
    }
}

package com.bobo.leetcode53;

/**
 * @author by bobo
 * @Description leet53 最大子数组和
 * @Date 2022/9/1 12:13 PM
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        //贪心
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

    /**
     * 贪心方法解决
     */
    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int cur = 0;
        for (int num : nums) {
            cur = Math.max(cur + num, num);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(new Solution().maxSubArray2(arr));
    }
}

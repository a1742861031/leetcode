package com.bobo.leetcode279;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author by bobo
 * @Description leetcode 279 完全平方数
 * @Date 2022/10/18 10:14
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                set.add(i * i);
            }
        }
        Integer[] nums = set.toArray(new Integer[]{});
        //先遍历物品。再遍历背包
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= n; j++) {
                if (dp[j - nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - nums[i]]+1, dp[j]);
                }
            }
        }
        if(dp[n]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}

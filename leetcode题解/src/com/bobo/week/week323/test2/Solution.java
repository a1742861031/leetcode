package com.bobo.week.week323.test2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description 6258. 数组中最长的方波
 * @Date 2022/12/11 10:53
 */
public class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }
        int pre = 1;
        for (int i = 1; i <= n; i++) {
            //当前值
            dp[i] = pre;
            int num = nums[i - 1];
            double sqrt = Math.sqrt(num);
            int intValue = (int) sqrt;
            if (Math.abs(intValue - sqrt) < Double.MIN_VALUE) {
                if (map.containsKey(intValue)) {
                    Integer index = map.get(intValue);
                    dp[i] = Math.max(dp[i], dp[index + 1] + 1);
                    pre = dp[i];
                }
            }
        }
        if (dp[n] == 1) {
            return -1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 6, 16, 8, 2};
        System.out.println(new Solution().longestSquareStreak(arr));
    }
}

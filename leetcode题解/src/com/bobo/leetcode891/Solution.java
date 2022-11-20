package com.bobo.leetcode891;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description 子序列宽度之和
 * @Date 2022/11/18 09:05
 */
public class Solution {
    public int sumSubseqWidths(int[] nums) {
        long ans = 0;
        Arrays.sort(nums);
        int mod = (int) (1e9 + 7);
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        for (int i = 0; i < nums.length; i++) {
            ans += (long) (pow[i] - pow[nums.length - 1 - i]) * nums[i];
        }
        return (int) ((ans % mod + mod) % mod);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50, 62, 92, 44, 67, 38, 92, 22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16, 94, 16, 77, 92, 9, 30, 13};
        int i = new Solution().sumSubseqWidths(arr);
        System.out.println(i);
    }
}

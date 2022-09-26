package com.bobo.leetcode1005;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author by bobo
 * @Description K 次取反后最大化的数组和
 * @Date 2022/9/24 09:01
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> {
            return Math.abs(o2) - Math.abs(o1);
        }).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            nums[nums.length-1] = -nums[nums.length-1];
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int i = new Solution().largestSumAfterKNegations(nums, 1);
        System.out.println(i);
    }
}

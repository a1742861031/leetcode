package com.bobo.leetcode1365;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode 1365 有多少小于当前数字的数字
 * @Date 2022/11/9 09:24
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        map.put(nums[0], 0);
        int index = 1;
        while (index < nums.length) {
            if (nums[index] > nums[index - 1]) {
                map.put(nums[index],index);
            }
            index++;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < newNums.length; i++) {
            ans[i] = map.get(newNums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        new Solution().smallerNumbersThanCurrent(nums);
    }
}

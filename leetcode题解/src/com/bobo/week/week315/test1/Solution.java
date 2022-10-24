package com.bobo.week.week315.test1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author by bobo
 * @Description 6204. 与对应负数同时存在的最大正整数
 * @Date 2022/10/16 11:18
 */
public class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set1 = new HashSet<>();

        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                set1.add(nums[i]);
            } else {
                index = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= index; i--) {
            if (set1.contains(-nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int maxK = new Solution().findMaxK(nums);
        System.out.println(maxK);
    }
}

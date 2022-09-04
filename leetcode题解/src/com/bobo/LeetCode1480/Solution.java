package com.bobo.LeetCode1480;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description LeetCode1480 一维数组的动态和
 * @Date 2022/7/4 9:23 AM
 */
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Solution solution = new Solution();
        int[] resultArr = solution.runningSum(arr);
        for (int i : resultArr) {
            System.out.println(i);
        }
    }
}

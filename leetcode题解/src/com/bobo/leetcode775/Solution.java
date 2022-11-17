package com.bobo.leetcode775;

/**
 * @author by bobo
 * @Description leetcode775 全局倒置与局部倒置
 * @Date 2022/11/16 09:29
 */
public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int length = nums.length;
        /*
         * 全局倒置和局部倒置数量要相等的话
         * 需满足没有当i<j+1时，num[i]>nums[j]
         */
        int minMatrix = nums[length - 1];
        int index = length - 1;
        for (int i = length - 3; i >= 0; i--) {
            if (nums[i] > minMatrix && (index - i) > 1) {
                return false;
            }
            index--;
            minMatrix = Math.min(minMatrix,nums[index]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0, 3};
        System.out.println(new Solution().isIdealPermutation(arr));

    }
}

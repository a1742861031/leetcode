package com.bobo.leetcode189;

/**
 * @author by bobo
 * @Description leetcode189 轮转数组
 * @Date 2022/9/2 11:54 AM
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 从begin开始，end结束反转nums
     */
    public void reverse(int[] nums, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        solution.rotate(arr, 3);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

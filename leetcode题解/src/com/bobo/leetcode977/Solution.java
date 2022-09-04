package com.bobo.leetcode977;

/**
 * @author by bobo
 * @Description leetcode 977 有序数字的平方和
 * @Date 2022/9/2 10:13 AM
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int negative = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }
        //左右指针位置一定要找准
        int left = negative;
        int right = negative + 1;
        while (left >= 0 || right < nums.length) {
            if (left < 0) {
                arr[index] = nums[right] * nums[right];
                right++;
            } else if (right >= nums.length) {
                arr[index] = nums[left] * nums[left];
                left--;
            } else if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                arr[index] = nums[left] * nums[left];
                left--;
            } else {
                arr[index] = nums[right] * nums[right];
                right++;
            }
            index++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{-4, -3, -2, -1};
        int[] ints = solution.sortedSquares(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}

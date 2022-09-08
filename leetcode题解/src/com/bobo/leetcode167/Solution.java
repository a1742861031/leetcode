package com.bobo.leetcode167;

/**
 * @author by bobo
 * @Description leetcode第167题
 * @Date 2022/9/4 12:53 PM
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] ans = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4};
        int[] ints = new Solution().twoSum(arr, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

package com.bobo.leetcode283;

/**
 * @author by bobo
 * @Description leetcode 283 移动零
 * @Date 2022/9/3 10:05 AM
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int j = i;
                while (j > 0 && nums[j - 1] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    j--;
                }
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                i = k;
                break;
            }
        }
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,12,0,1};
        Solution solution = new Solution();
        solution.moveZeroes1(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

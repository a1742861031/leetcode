package com.bobo.leetcode922;

/**
 * @author by bobo
 * @Description leetcode 922 按奇偶排序数组 ||
 * @Date 2022/11/9 10:12
 */
public class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int[] temp = new int[nums.length];
        int point1 = 0, point2 = nums.length / 2;
        for (int num : nums) {
            if (num % 2 == 0) {
                temp[point1] = num;
                point1++;
            } else {
                temp[point2] = num;
                point2++;
            }
        }
        point1 = 0;
        point2 = nums.length / 2;
        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 0) {
                ans[i] = temp[point1];
                point1++;
            } else {
                ans[i] = temp[point2];
                point2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 7, 3, 2};
        new Solution().sortArrayByParityII(nums);
    }
}

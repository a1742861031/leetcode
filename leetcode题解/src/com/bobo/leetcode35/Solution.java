package com.bobo.leetcode35;

/**
 * @author by bobo
 * @Description leetcode35 搜索插入位置
 * @Date 2022/9/1 11:49 AM
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return target;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(ans, 7));

    }
}

package com.bobo.LeetCode704;

/**
 * @author by bobo
 * @Description LeetCode704 二分查找
 * @Date 2022/8/31 1:42 PM
 */
public class Solution {
    public int search(int[] nums, int target) {
        //左闭右闭的写法
        int left = 0, right = nums.length;
        if (nums.length == 0) {
            return -1;
        }
        do {

            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        } while (left < right);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 5};
        System.out.println(new Solution().search(arr, -1));
    }
}

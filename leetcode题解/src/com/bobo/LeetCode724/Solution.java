package com.bobo.LeetCode724;

/**
 * @author by bobo
 * @Description LeetCode724 寻找数组的中心下标
 * @Date 2022/7/4 9:43 AM
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int index = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i1 = 1; i1 < nums.length; i1++) {
            rightSum += nums[i1];
        }
        if (leftSum == rightSum) {
            return index;
        }
        for (index = 1; index < nums.length; index++) {
            leftSum += nums[index - 1];
            rightSum -= nums[index];
            if (leftSum == rightSum) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,-1};
        Solution solution = new Solution();
        int i = solution.pivotIndex(arr);
        System.out.println(i);
    }
}

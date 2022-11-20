package com.bobo.leetcode1732;

/**
 * @author by bobo
 * @Description leetcode 1732 找到最高海拔
 * @Date 2022/11/19 19:43
 */
public class Solution {


    public int largestAltitude(int[] gain) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4,-3,-2,-1,4,3,2};
        System.out.println(new Solution().largestAltitude(arr));

    }
}

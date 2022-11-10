package com.bobo.leetcode941;

/**
 * @author by bobo
 * @Description 有效的山脉数组
 * @Date 2022/11/9 09:38
 */
public class Solution {
    public boolean validMountainArray(int[] arr) {
        int i;
        for (i = 1; i < arr.length; i++) {

            if (arr[i] < arr[i - 1]) {
                if (i - 1 == 0) {
                    return false;
                }
                break;
            }
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        if (i == arr.length) {
            return false;
        }
        for (; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,2,1};
        System.out.println(new Solution().validMountainArray(arr));
    }
}

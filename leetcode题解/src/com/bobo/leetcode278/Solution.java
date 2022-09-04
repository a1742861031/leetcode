package com.bobo.leetcode278;

/**
 * @author by bobo
 * @Description leetcode278 第一个错误的版本
 * @Date 2022/9/1 11:25 AM
 */
public class Solution {
    public int firstBadVersion(int n) {
        int right = n, left = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int index) {
        return false;
    }
}

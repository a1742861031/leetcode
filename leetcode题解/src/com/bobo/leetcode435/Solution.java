package com.bobo.leetcode435;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description 无重叠区间
 * @Date 2022/9/28 10:09
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        //排序
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //有重叠
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        new Solution().eraseOverlapIntervals(arr);
    }
}

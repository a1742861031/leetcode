package com.bobo.leetcode452;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description 用最少数量的剑引爆气球
 * @Date 2022/9/28 09:14
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = 1;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int a1 = points[0][0];
        int a2 = points[0][1];
        for (int i = 0; i < points.length - 1; i++) {
            boolean result = judgeHasIntersection(a1, a2, points[i + 1][0], points[i + 1][1]);
            if (result) {
                a1 = Math.max(a1, points[i + 1][0]);
                a2 = Math.min(a2, points[i + 1][1]);
            } else {
                count++;
                a1 = points[i + 1][0];
                a2 = points[i + 1][1];
            }
        }
        return count;
    }

    public boolean judgeHasIntersection(int a1, int a2, int b1, int b2) {
        if (a1 < b1 && a2 < b1) {
            return false;
        }
        if (a1 > b1 && a2 > b1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        new Solution().findMinArrowShots(arr);
    }
}

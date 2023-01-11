package com.bobo.week.week323.test1;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description
 * @Date 2022/12/11 10:30
 */
public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int index = grid[0].length - 1;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int currentMax = Integer.MIN_VALUE;
        for (int i = index; i >= 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > currentMax) {
                    currentMax = grid[j][i];
                }
            }
            ans += currentMax;
            currentMax = Integer.MIN_VALUE;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arrs = new int[][]{{10}};
        System.out.println(new Solution().deleteGreatestValue(arrs));
    }
}

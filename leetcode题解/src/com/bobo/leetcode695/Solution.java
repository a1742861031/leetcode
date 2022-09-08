package com.bobo.leetcode695;

/**
 * @author by bobo
 * @Description 岛屿的最大面积
 * @Date 2022/9/8 9:44 AM
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] currentAns = new int[]{0};
                    currentAns(grid, i, j, currentAns);
                    if (ans < currentAns[0]) {
                        ans = currentAns[0];
                    }
                }
            }
        }
        return ans;
    }

    public void currentAns(int[][] grid, int row, int col, int[] ans) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == 2) {
            return;
        }
        ans[0]++;
        grid[row][col] = 2;
        currentAns(grid, row + 1, col, ans);
        currentAns(grid, row, col + 1, ans);
        currentAns(grid, row - 1, col, ans);
        currentAns(grid, row, col - 1, ans);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new Solution().maxAreaOfIsland(arr));
    }
}

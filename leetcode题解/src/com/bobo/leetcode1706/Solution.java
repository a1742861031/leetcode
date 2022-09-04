package com.bobo.leetcode1706;

/**
 * @author by bobo
 * @Description 球会落在何处
 * @Date 2022/8/4 10:35 AM
 */
public class Solution {
    private int n, m;

    /**
     * dfs深度优先
     *
     * @param grid 挡板位置
     * @param i    小球在第多少行
     * @param j    小球在第多少列
     * @return 小球最终所在位置
     */
    private int dfs(int[][] grid, int i, int j) {
        if (i == n) {
            return j;
        }
        if (grid[i][j] == 1 && j + 1 < m && grid[i][j + 1] == 1) {
            return dfs(grid, i + 1, j + 1);
        } else if (grid[i][j] == -1 && j > 0 && grid[i][j - 1] == -1) {
            return dfs(grid, i + 1, j - 1);
        }
        return -1;
    }

    public int[] findBall(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = dfs(grid, 0, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        Solution solution = new Solution();
        int[] ball = solution.findBall(grid);
        for (int i : ball) {
            System.out.println(i);
        }

    }
}

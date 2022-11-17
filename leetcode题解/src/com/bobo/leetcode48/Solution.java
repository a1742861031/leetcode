package com.bobo.leetcode48;

/**
 * @author by bobo
 * @Description 旋转图像
 * @Date 2022/11/14 19:15
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i <= j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(arr);
    }
}

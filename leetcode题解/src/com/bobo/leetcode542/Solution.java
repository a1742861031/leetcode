package com.bobo.leetcode542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by bobo
 * @Description leetcode542 01矩阵
 * @Date 2022/9/13 9:45 AM
 */
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        //遍历
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    int[] cur = new int[]{i, j};
                    //将0入队列
                    queue.offer(cur);
                } else {
                    //1置为-1
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < mat.length && my >= 0 && my < mat[0].length && mat[mx][my] == -1) {
                    mat[mx][my] = mat[x][y] + 1;
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        return mat;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        solution.updateMatrix(mat);
    }
}

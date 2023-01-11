package com.bobo.offer.offer12;

/**
 * @author by bobo
 * @Description offer12 矩阵中的路径
 * @Date 2023/1/11 12:44
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int w = board.length;
        int h = board[0].length;
        boolean[][] visited = new boolean[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                boolean check = check(board, visited, i, j, word, 0);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (s.charAt(k) != board[i][j]) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean result = false;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!visited[newI][newJ]) {
                    boolean flag = check(board, visited, newI, newJ, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution().exist(board, "ABCCED"));
    }
}

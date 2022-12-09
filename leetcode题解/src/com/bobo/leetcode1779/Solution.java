package com.bobo.leetcode1779;

/**
 * @author by bobo
 * @Description leetcode 1779.找到最近的有相同 X 或 Y 坐标的点
 * @Date 2022/12/8 19:46
 */
public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManhattan = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            if (x1 == x || y1 == y) {
                int cur = Math.abs(x - x1) + Math.abs(y - y1);
                if (cur < minManhattan) {
                    minManhattan = cur;
                    ans = i;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}

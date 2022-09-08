package com.bobo.leetcode733;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by bobo
 * @Description 图像渲染
 * @Date 2022/9/7 9:25 AM
 */

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        helper(image, sr, sc, oldColor, color);
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int oldColor, int newColor) {
        //当满足条件时，直接return
        //条件1：不越界
        //条件2：当前颜色与最开始方块颜色相同
        //条件3:新的颜色不等于最开始方块颜色
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || newColor == oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        //左
        helper(image, sr - 1, sc, oldColor, newColor);
        //上
        helper(image, sr, sc - 1, oldColor, newColor);
        //右
        helper(image, sr + 1, sc, oldColor, newColor);
        //下
        helper(image, sr, sc + 1, oldColor, newColor);
    }

    public int[][] floodFillWithBfs(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        //定义如何移动
        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};
        if (color == image[sr][sc]) {
            return image;
        }
        //通过quene记录当前需要上色的中心值
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        //当quene为0后，就说明所有的色都上完了
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            //当前中心位置
            int x = poll[0], y = poll[1];
            //对当前中心上下左右进行上色
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < image.length && my < image[0].length && image[mx][my] == currentColor) {
                    //上色后应该记录上了色的坐标，通过这个坐标再对上下左右进行上色
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ints = new Solution().floodFillWithBfs(image, 1, 1, 2);
    }
}

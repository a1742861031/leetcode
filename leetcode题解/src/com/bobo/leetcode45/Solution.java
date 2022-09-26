package com.bobo.leetcode45;

/**
 * @author by bobo
 * @Description leetcode45 跳跃游戏2
 * @Date 2022/9/23 11:05
 */
public class Solution {
    public int jump(int[] nums) {
        int cover = 0;
        int step;
        for (int i = 0; i <= cover; i++) {
            if (nums[i] + i > cover) {
                cover = nums[i] + i;
                //最优的跳法
                
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
    }
}

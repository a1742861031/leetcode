package com.bobo.leetcode55;

/**
 * @author by bobo
 * @Description leetcode55 跳跃游戏
 * @Date 2022/9/23 10:04
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            //贪心策略：每次取最大的跳跃步数
            //更新cover
            cover = Math.max(i + nums[i], cover);
            //cover是否能到达最后一个下标
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 8, 2, 0, 0, 1};
        System.out.println(new Solution().canJump(nums));
    }
}

package com.bobo.leetcode135;

/**
 * @author by bobo
 * @Description 135 分发糖果
 * @Date 2022/9/25 20:53
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        ans[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            ans[i] = (ratings[i] > ratings[i - 1]) ? ans[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int an : ans) {
            sum += an;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] rating = new int[]{1, 0, 2};
        System.out.println(new Solution().candy(rating));
    }
}

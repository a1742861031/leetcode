package com.bobo.leetcode122;

/**
 * @author by bobo
 * @Description 买卖股票的最佳时机2
 * @Date 2022/9/23 09:36
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int[] sub = new int[prices.length - 1];
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            sub[index] = prices[i] - prices[i - 1];
            index++;
        }
        for (int i : sub) {
            if (i > 0) {
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}

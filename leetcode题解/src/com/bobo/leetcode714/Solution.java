package com.bobo.leetcode714;

/**
 * @author by bobo
 * @Description 买卖股票的最佳时机 带手续费
 * @Date 2022/10/3 10:21
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] >= minPrice && prices[i] <= minPrice + fee) {
                continue;
            } else if (prices[i] > minPrice + fee) {
                result += (prices[i] - minPrice - fee);
                //为什么是price[i]-fee
                minPrice = prices[i] - fee;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        System.out.println(new Solution().maxProfit(prices, 3));
    }
}

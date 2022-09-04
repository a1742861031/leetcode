package com.bobo.leetcode121;

/**
 * @author by bobo
 * @Description 买股票的最佳时机
 * @Date 2022/7/6 10:18 AM
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int come = 0;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int comeTemp = prices[i] - min;
            if (prices[i] < min) {
                min = prices[i];
            }
            if (comeTemp > come) {
                come = comeTemp;
                result = come;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(arr));
    }
}

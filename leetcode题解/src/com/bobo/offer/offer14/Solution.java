package com.bobo.offer.offer14;

/**
 * @author by bobo
 * @Description 减绳子
 * @Date 2023/1/11 13:29
 */
public class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int curMax = -1;
            for (int j = 0; j < i; j++) {
                /*
                 * 将绳子分成j和i-j
                 * 一种情况是分成两份
                 * 另一种情况是i-j长度的绳子继续分
                 */
                curMax = Math.max(Math.max(j * (i - j), j * dp[i - j]), curMax);
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}

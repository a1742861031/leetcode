package com.bobo.leetcode509;

/**
 * @author by bobo
 * @Description 动态规划解 斐波那契数
 * @Date 2022/10/4 09:55
 */
public class Solution {
    public int fib(int n) {
        /**
         *确定dp数组及其下标的含义
         *dp[i] 表示第i个斐波那契数
         *int[] dp = new int[n];
         *确定递推公式
         *dp[i] = dp[i-1]+dp[i-2]
         *确定dp数组如何初始化
         *dp[0] = 1.dp[1] = 1
         *确定遍历顺序
         *从前向后遍历
         *确定打印顺序
         **/
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}

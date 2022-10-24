package com.bobo.leetcode474;

/**
 * @author by bobo
 * @Description 一零和
 * @Date 2022/10/15 22:50
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //确定dp数组
        int[][] dp = new int[m + 1][n + 1];
        //dp数组的含义，当dp[i][j] 最多有i个0，j个1的子集个数为dp[i][j]
        dp[0][0] = 0;
        //遍历物品
        for (String str : strs) {
            int m1 = 0, n1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    m1++;
                } else {
                    n1++;
                }
            }
            //背包从后往前遍历
            for (int i = m; i >= m1; i--) {
                for (int j = n; j >= n1; j--) {
                    dp[i][j] = Math.max(dp[i - m1][j - n1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"11111", "100", "1101", "1101", "11000"};
        Solution solution = new Solution();
        int maxForm = solution.findMaxForm(strs, 5, 7);
        System.out.println(maxForm);
    }
}

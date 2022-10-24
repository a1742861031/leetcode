package com.bobo.leetcode583;

/**
 * @author by bobo
 * @Description leetcode 583 两个字符串的删除操作
 * @Date 2022/10/24 10:00
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int maxCommonLength = dp[length1][length2];
        return (length1-maxCommonLength)+(length2-maxCommonLength);
    }

    public static void main(String[] args) {

    }
}

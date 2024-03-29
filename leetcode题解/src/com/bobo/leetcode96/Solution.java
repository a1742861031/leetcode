package com.bobo.leetcode96;

/**
 * @author by bobo
 * @Description leetcode95 不同的二叉搜索树
 * @Date 2022/11/26 09:45
 */
public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += (G[j - 1] * G[i - j]);
            }
        }
        return G[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}

package com.bobo.leetcode455;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode455 题 分发饼干
 * @Date 2022/9/21 10:32
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int ans = 0;
        //拿最大的饼干能满足的最大胃口的孩子，前面的都能满足
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                ans++;
                index--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new Solution().findContentChildren(g, s));
    }
}

package com.bobo.leetcode;

import java.util.*;

/**
 * @author by bobo
 * @Description 139 单词拆分
 * @Date 2022/10/19 09:17
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        Arrays.fill(dp, false);
        dp[0] = true;
        //，再遍历背包 再遍历物品
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (set.contains(subStr) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);
    }
}

package com.bobo.leetcode14;

/**
 * @author by bobo
 * @Description 最长公共前缀
 * @Date 2022/8/4 10:55 AM
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int minLen = strs[0].length();
        for (String str : strs) {
            if (minLen > str.length()) {
                minLen = str.length();
            }
        }
        int index = 0;
        char common = 0;
        boolean isEqual = true;
        for (int k = 0; k < minLen; k++) {
            for (int i = 0; i < strs.length; i++) {
                if (index >= minLen) {
                    break;
                }
                if (i == 0) {
                    common = strs[i].charAt(index);
                } else {
                    char c = strs[i].charAt(index);
                    if (c != common) {
                        isEqual = false;
                        break;
                    }
                }
            }
            index++;
            if (isEqual) {
                prefix.append(common);
            } else {
                break;
            }
        }
        return String.valueOf(prefix);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        Solution solution = new Solution();
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }
}

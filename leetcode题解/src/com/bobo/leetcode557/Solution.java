package com.bobo.leetcode557;

/**
 * @author by bobo
 * @Description leetcode 第557题 反转字符串中的单词 III
 * @Date 2022/9/4 12:30 PM
 */
public class Solution {
    public String reverseWords(String s) {
        String[] items = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String item : items) {
            StringBuffer reverse = new StringBuffer(item).reverse();
            ans.append(reverse);
            ans.append(" ");
        }
        ans.delete(ans.length()-1,ans.length());
        return String.valueOf(ans);
    }



    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}

package com.bobo.leetcode151;

/**
 * @author by bobo
 * @Description leetcode 151 反转字符串中的单词
 * @Date 2022/11/2 10:09
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int beginIndex = 0;
        int endIndex = s.length() - 1;
        for (; beginIndex < s.length(); beginIndex++) {
            if (s.charAt(beginIndex) != ' ') {
                break;
            }
        }
        for (; endIndex >= 0; endIndex--) {
            if (s.charAt(endIndex) != ' ') {
                break;
            }
        }
        String[] strings = s.substring(beginIndex, endIndex+1).split(" ");
        for (int i = strings.length - 1; i > 0; i--) {
            if(strings[i].trim().length()!=0){
                ans.append(strings[i]);
                ans.append(" ");
            }

        }
        ans.append(strings[0]);
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().reverseWords("  hello world  ");
        System.out.println(s);
    }
}

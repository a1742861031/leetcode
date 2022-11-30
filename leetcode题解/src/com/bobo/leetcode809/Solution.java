package com.bobo.leetcode809;

/**
 * @author by bobo
 * @Description leetcode809 情感丰富的文字
 * @Date 2022/11/25 15:52
 */
public class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (judgeStretchy(s, word)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean judgeStretchy(String s, String word) {
        if (word.length() > s.length()) {
            return false;
        }
        if (word.length() == s.length() && !word.equals(s)) {
            return false;
        }
        int point1 = 0, point2 = 0;
        for (; point2 < word.length(); point2++) {
            char c = word.charAt(point2);
            if (c != s.charAt(point1)) {
                return false;
            }
            if (point2 == word.length() - 1 || word.charAt(point2) != word.charAt(point2 + 1)) {
                if (s.charAt(point1) == s.charAt(point1 + 1)) {
                    int count = 1;
                    char c1 = s.charAt(point1);
                    int temp = point1;
                    while (point1 < s.length() - 1) {
                        point1++;
                        if (s.charAt(point1) != c1) {
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (point1 == s.length() - 1) {
                        point1++;
                    }
                    if (count < 3) {
                        point1 = temp + 1;
                    }
                } else {
                    point1 += 1;
                }
            } else {
                point1++;
            }
        }
        if (point1 < s.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String[] strings = new String[]{"aaaa"};
        System.out.println(new Solution().expressiveWords(s, strings));
    }
}

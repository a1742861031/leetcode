package com.bobo.leetcode1805;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by bobo
 * @Description leetcode1805 字符串中不同整数的数目
 * @Date 2022/12/8 19:59
 */
public class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                s.append(word.charAt(i));
            } else {
                if (s.length() != 0) {
                    set.add(s.toString().replaceFirst("\\b0+", ""));
                    s = new StringBuilder("");

                }
            }
        }
        if (s.length() != 0) {
            set.add(s.toString().replaceFirst("\\b0+", ""));
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        new Solution().numDifferentIntegers("leet1234code234");
    }
}

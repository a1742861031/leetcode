package com.bobo.leetcode792;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description leetcode792 匹配子序列的单词数
 * @Date 2022/11/17 17:15
 */
public class Solution {
    /**
     * 通过数组存当前字母所在的位置
     */
    private List<Integer>[] d = new List[26];

    public int numMatchingSubseq(String s, String[] words) {
        for (int i = 0; i < 26; ++i) {
            d[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); ++i) {
            d[s.charAt(i) - 'a'].add(i);
        }
        int ans = 0;
        for (String w : words) {
            if (check(w)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String w) {
        int i = -1;
        for (int k = 0; k < w.length(); ++k) {
            int c = w.charAt(k) - 'a';
            int j = search(d[c], i);
            if (j == d[c].size()) {
                return false;
            }
            i = d[c].get(j);
        }
        return true;
    }

    private int search(List<Integer> t, int x) {
        int left = 0, right = t.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (t.get(mid) > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] strings = new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        int count = new Solution().numMatchingSubseq(s, strings);
        System.out.println(count);
    }
}

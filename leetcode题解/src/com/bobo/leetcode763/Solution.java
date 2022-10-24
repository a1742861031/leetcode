package com.bobo.leetcode763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode 763 划分字母区间-贪心
 * @Date 2022/9/29 13:36
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer cur = map.get(s.charAt(i));
            for (int j = i + 1; j < cur; j++) {
                Integer cur1 = map.get(s.charAt(j));
                if (cur1 > cur) {
                    cur = cur1;
                }
            }
            ans.add(cur - pre);
            pre = cur;
            i = cur;
        }
        Integer first = ans.remove(0);
        ans.add(0, first + 1);
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new Solution().partitionLabels(s));
    }
}

package com.bobo.leetcode791;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode791 自定义字符串排序
 * @Date 2022/11/16 10:01
 */
public class Solution {
    public String customSortString(String order, String s) {
        //构建hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        String[] ans = new String[s.length() * 2];
        int elseIndex = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int index = map.get(s.charAt(i));
                if (ans[index] != null) {
                    ans[index] = ans[index] + s.charAt(i) + "";
                } else {
                    ans[index] = s.charAt(i) + "";
                }
            } else {
                if (ans[elseIndex] != null) {
                    ans[elseIndex] = ans[elseIndex] + s.charAt(i) + "";
                } else {
                    ans[elseIndex] = s.charAt(i) + "";
                }
                elseIndex++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String an : ans) {
            if (an != null) {
                stringBuilder.append(an);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().customSortString("kqep", "pekeq"));
    }
}

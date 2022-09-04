package com.bobo.LeetCode205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description LeetCode205. 同构字符串
 * @Date 2022/7/4 10:37 AM
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map1.containsKey(a) && map1.get(a) != b || map2.containsKey(b) && map2.get(b) != a) {
                return false;
            }
            map1.put(a,b);
            map2.put(b,a);

        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "badc";
        String t = "baba";
        System.out.println(solution.isIsomorphic(s, t));
    }
}
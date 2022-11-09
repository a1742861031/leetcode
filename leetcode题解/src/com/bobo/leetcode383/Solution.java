package com.bobo.leetcode383;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode383. 赎金信
 * @Date 2022/10/28 09:45
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), 1);
            } else {
                Integer count = map.get(magazine.charAt(i));
                map.put(magazine.charAt(i), count + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0) {
                int newCount = map.get(ransomNote.charAt(i)) - 1;
                map.put(ransomNote.charAt(i), newCount);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("aa", "aab"));
    }
}

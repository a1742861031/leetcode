package com.bobo.leetcode1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author by bobo
 * @Description 独一无二的出现次数
 * @Date 2022/11/9 10:05
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer key : map.keySet()) {
            set.add(map.get(key));
        }
        return set.size() == map.keySet().size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
        new Solution().uniqueOccurrences(arr);
    }
}

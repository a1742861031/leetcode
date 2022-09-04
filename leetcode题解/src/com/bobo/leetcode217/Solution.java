package com.bobo.leetcode217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by bobo
 * @Description leetcode217 存在重复元素
 * @Date 2022/8/31 2:55 PM
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> items = new HashSet<>();
        for (int num : nums) {
            if (items.contains(num)) {
                return true;
            } else {
                items.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}

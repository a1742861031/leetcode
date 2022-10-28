package com.bobo.leetcode349;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by bobo
 * @Description leetcode349 两个数组的交集
 * @Date 2022/10/26 10:41
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> commonSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                commonSet.add(i);
            }
        }
        int[] ans = new int[commonSet.size()];
        int i = 0;
        for (Integer integer : commonSet) {
            ans[i] = integer;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        new Solution().intersection(nums1,nums2);
    }
}

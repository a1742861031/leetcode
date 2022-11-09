package com.bobo.leetcode454;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode 454 四数相加 II
 * @Date 2022/10/28 09:17
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    Integer curCount = map.get(sum);
                    map.put(sum, curCount + 1);
                }
            }
        }
        //遍历 num3 和num4
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(-sum)) {
                    Integer count = map.get(-sum);
                    ans += count;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

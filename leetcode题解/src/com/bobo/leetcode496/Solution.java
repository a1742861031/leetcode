package com.bobo.leetcode496;

import java.util.*;

/**
 * @author by bobo
 * @Description 496. 下一个更大元素 I
 * @Date 2022/10/25 10:41
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (stack.isEmpty() || nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    map.put(stack.peek(), nums2[i]);
                    stack.pop();
                }
                stack.push(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums1, nums2)));
    }
}

package com.bobo.leetcode16;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description leetcode 第16题 最接近的三数之和
 * @Date 2022/8/8 9:15 AM
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //将数组进行排序
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        int reduce = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int x = nums[i], y = nums[j], z = nums[k];
                int item = Math.abs(target - (x + y + z));
                if (reduce > item) {
                    ans = x + y + z;
                    reduce = item;
                }
                if ((x + y + z) < target) {
                    j++;
                } else if ((x + y + z) > target) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}

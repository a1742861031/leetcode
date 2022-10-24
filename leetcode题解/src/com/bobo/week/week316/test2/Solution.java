package com.bobo.week.week316.test2;

/**
 * @author by bobo
 * @Description 6224. 最大公因数等于 K 的子数组数目
 * @Date 2022/10/23 10:44
 */
public class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num == k) {
                ans++;
            }
        }
        // 对于每个位置都求包含他本身在内的所有连续子数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                continue;
            }
            int pre = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < k) {
                    break;
                }
                pre = gcb(pre, nums[j]);
                if (pre == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int gcb(int m, int n) {
        int z = 0;
        while (m % n != 0) {
            z = m % n;
            m = n;
            n = z;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 2, 6, 3};
        System.out.println(new Solution().subarrayGCD(nums, 3));
    }
}

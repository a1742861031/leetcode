package com.bobo.leetcode376;

/**
 * @author by bobo
 * @Description leetcode 376 摆动序列
 * @Date 2022/9/22 10:10
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int ans = 0;
        int begin = 0;
        do {
            begin++;
        } while (begin < nums.length && nums[begin] == nums[begin - 1]);
        if (begin == nums.length) {
            return 1;
        }
        ans+=2;
        int pre = nums[begin] - nums[begin - 1];
        for (int i = begin+1; i < nums.length; i++) {
            int cur = nums[i] - nums[i - 1];
            if (pre < 0 && cur > 0) {
                pre = cur;
                ans++;
            }
            if (pre > 0 && cur < 0) {
                pre = cur;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(new Solution().wiggleMaxLength(nums));
    }
}

package com.bobo.week.week320.test1;

/**
 * @author by bobo
 * @Description 6241. 数组中不等三元组的数目
 * @Date 2022/11/20 10:31
 */
public class Solution {
    public int unequalTriplets(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(solution.unequalTriplets(nums));
    }
}

package com.bobo.leetcode01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description LeetCode第一题：两数之和
 * @Date 2021/10/22 13:36
 * @Created by bobo
 */
public class LeetCode01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1}; //返回的结果
        if(nums.length<2){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode01 leetCode01 = new LeetCode01();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = leetCode01.twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}

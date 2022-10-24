package com.bobo.week.week315.test2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author by bobo
 * @Description 6205. 反转之后不同整数的数目
 * @Date 2022/10/16 11:30
 */
public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            //添加反转后的数字
            set.add(reverse(nums[i]));
        }

        return set.size();
    }

    public int reverse(int x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return (int) y == y ? (int) y : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,2,2};
        System.out.println(solution.countDistinctIntegers(arr));
    }
}

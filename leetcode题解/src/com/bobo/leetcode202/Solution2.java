package com.bobo.leetcode202;

import java.util.HashMap;

/**
 * @author by bobo
 * @Description 哈希表解法
 * @Date 2022/7/19 8:23 PM
 */
public class Solution2 {
    public boolean isHappy(int n) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        String stringNum = String.valueOf(n);
        //计算出和
        while (true) {
            sum = 0;
            for (int i = 0; i < stringNum.length(); i++) {
                int item = stringNum.charAt(i) - '0';
                sum = item * item + sum;
            }
            if (sum == 1) {
                return true;
            }
            if (map.containsKey(sum)) {
                return false;
            } else {
                map.put(sum, 1);
                stringNum = String.valueOf(sum);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isHappy(2));
    }
}

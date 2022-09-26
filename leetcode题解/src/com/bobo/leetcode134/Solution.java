package com.bobo.leetcode134;

/**
 * @author by bobo
 * @Description 加油站
 * @Date 2022/9/24 11:02
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int curRes = gas[i] - cost[i];
            curSum += curRes;
            if (curSum < min) {
                min = curSum;
            }
        }
        if (curSum < 0) {
            return -1;
        }
        if (min > 0) {
            return 0;
        }
        //填平
        for (int i = gas.length - 1; i >= 0; i--) {
            int res = gas[i] - cost[i];
            min += res;
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}

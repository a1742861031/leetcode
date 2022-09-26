package com.bobo.leetcode860;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description 860 柠檬水找零
 * @Date 2022/9/26 09:50
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        int num5 = 0;
        int num10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                num5++;
            } else if (bills[i] == 10) {
                if (num5 > 0) {
                    num5--;
                    num10++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if ((num5 > 0 && num10 > 0) || num5 >= 3) {
                    if (num5 >= 3) {
                        num5 -= 3;
                    } else {
                        num5--;
                        num10--;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5};
        new Solution().lemonadeChange(arr);
    }
}

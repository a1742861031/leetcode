package com.bobo.leetcode1742;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode 1742盒子中小球的最大数量
 * @Date 2022/11/23 09:19
 */
public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            String s = String.valueOf(i);
            String[] split = s.split("");
            int sum = 0;
            for (String s1 : split) {
                sum += Integer.parseInt(s1);
            }
            if (map.containsKey(sum)) {
                Integer current = map.get(sum);
                current += 1;
                if (current > ans) {
                    ans = current;
                }
                map.put(sum, current);
            } else {
                map.put(sum, 1);
                if (ans < 1) {
                    ans = 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(1, 10));
    }
}

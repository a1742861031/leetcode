package com.bobo.leetcode738;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description leetcode738 单调递增的数字
 * @Date 2022/10/1 09:55
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String[] strings = (n + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("", strings));
    }

    /**
     * 得到数字的每一位
     */
    public List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        int i = new Solution().monotoneIncreasingDigits(332);
        System.out.println(i);
    }
}

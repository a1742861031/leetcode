package com.bobo.leetcode202;

/**
 * @author by bobo
 * @Description leetcode 202题 快乐数
 * @Date 2022/7/19 8:05 PM
 */
public class Solution {
    public boolean isHappy(int n) {
        //得到各位
        int num1 = 0;
        int numOther = 0;
        int sum = 0;
        String stringNum = Integer.toString(n);
        for (int i = 0; i < stringNum.length(); i++) {
            int item = stringNum.charAt(i) - '0';
            if (item == 1) {
                num1++;
            }
            if (item != 1 && item != -1) {
                numOther++;
            }
            sum = item * item + sum;
        }

        if (num1 == 1 && numOther == 0) {
            return true;
        } else {
            isHappy(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}

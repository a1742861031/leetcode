package com.bobo.week.week315.test3;

/**
 * @author by bobo
 * @Description 6219. 反转之后的数字和
 * @Date 2022/10/16 11:40
 */
public class Solution {
    public boolean sumOfNumberAndReverse(int num) {

        for (int i = 0; i <= num; i++) {
            if (reverse(i) + i == num) {
                return true;
            }
        }
        return false;
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
        System.out.println(solution.sumOfNumberAndReverse(181));
    }
}

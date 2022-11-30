package com.bobo.week.week321.test1;

/**
 * @author by bobo
 * @Description TODO
 * @Date 2022/11/27 10:52
 */
public class Solution {
    public int pivotInteger(int n) {
        int middle = n / 2;
        int leftSum = 0;
        int rightSum = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i < middle; i++) {
            leftSum += i;
        }
        for (int i = middle + 1; i <= n; i++) {
            rightSum += i;
        }
        while (true) {
            rightSum -= middle+1;
            leftSum += middle;
            if (leftSum == rightSum) {
                return middle+1;
            }
            if (middle >n ) {
                return -1;
            }
            middle++;
        }
    }

}

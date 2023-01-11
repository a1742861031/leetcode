package com.bobo.offer.offer11;

/**
 * @author by bobo
 * @Description 剑指 Offer 11. 旋转数组的最小数字
 * @Date 2022/12/9 10:22
 */
public class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int number = numbers[middle];
            if (number > numbers[right]) {
                left = middle + 1;
            } else if (number < numbers[right]) {
                right = middle;
            } else {
                //找到最左边
                right--;
            }
        }
        return numbers[left];
    }
}

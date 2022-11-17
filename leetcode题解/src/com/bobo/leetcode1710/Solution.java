package com.bobo.leetcode1710;

import java.util.Arrays;

/**
 * @author by bobo
 * @Description 卡车上的最大单位数
 * @Date 2022/11/15 09:40
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //将二维数组按照二维进行排序
        Arrays.sort(boxTypes, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize >= boxTypes[i][0]) {
                ans += (boxTypes[i][0]) * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                ans += (boxTypes[i][1]) * truckSize;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        Solution solution = new Solution();
        System.out.println(solution.maximumUnits(arr, 10));
    }
}

package com.bobo.leetcode56;

import java.util.*;

/**
 * @author by bobo
 * @Description leetcode56 合并区间
 * @Date 2022/9/30 12:21
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        //按照左区间进行排序
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //不能合并，加入前面的这个区间
            if (intervals[i][0] > right) {
                ans.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                left = Math.min(left,intervals[i][0]);
                //更新最大右边界
                right = Math.max(right,intervals[i][1]);
            }
        }
        ans.add(new int[]{left,right});
        //转为二维数组
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 6},{8,10},{15,18}};
        new Solution().merge(arr);

    }
}

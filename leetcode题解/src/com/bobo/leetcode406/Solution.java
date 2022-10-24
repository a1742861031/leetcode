package com.bobo.leetcode406;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author by bobo
 * @Description 406 根据身高重建队列
 * @Date 2022/9/27 09:51
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
//        int[][] deque = new int[people.length][2];
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                //这里根据第一列进行排序
//                return o1[0] - o2[0];
//            }
//        });
//        boolean[] used = new boolean[people.length];
//        for (int i = 0; i < people.length; i++) {
//            int index = people[i][1];
//            int findIndex = 0;
//            for (int i1 = 0; i1 < used.length; i1++) {
//                if (findIndex == index && !used[i1]) {
//                    deque[i1][0] = people[i][0];
//                    deque[i1][1] = people[i][1];
//                    used[i1] = true;
//                    break;
//                } else if (!used[i1] || deque[i1][0] >= people[i][0]) {
//                    findIndex++;
//                }
//
//            }
//        }
//
//        return deque;
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();
        //在p[1]位置插入p
        for (int[] p : people) {
            que.add(p[1], p);
        }

        return que.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        new Solution().reconstructQueue(people);
    }
}

package com.bobo.offer;

import java.util.ArrayList;

/**
 * @Description 反转链表
 * @Date 2022/3/11 11:12 PM
 * @Created by bobo
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            ArrayList<Integer> arr = new ArrayList<>();
            while (head.next != null) {
                arr.add(head.next.val);
                head = head.next;
            }
            int index = 0;
            int[] arr1 = new int[arr.size()];
            for (int i = arr.size() - 1; i >= 0; i--) {
                arr1[index] = arr.get(i);
                index++;
            }
            return arr1;
        }
    }

}

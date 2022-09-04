package com.bobo.LeetCode21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description LeetCode21  合并两个有序链表
 * @Date 2022/7/5 9:11 AM
 */

class Solution {
    /**
     * Definition for singly-linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> arr = new ArrayList<>();

        while (list1 != null || list2 != null) {
            int val1 = 0x7fffffff;
            int val2 = 0x7fffffff;
            if (list1 != null) {
                val1 = list1.val;
            }
            if (list2 != null) {
                val2 = list2.val;
            }
            if (val1 < val2) {
                arr.add(val1);
                list1 = list1.next;
            } else {
                arr.add(val2);
                list2 = list2.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (Integer integer : arr) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        head1.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode head2 = new ListNode(0);


        Solution solution = new Solution();
        solution.mergeTwoLists(null, head2);
    }
}

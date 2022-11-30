package com.bobo.week.week321.test3;

import com.bobo.LeetCode21.ListNode;

/**
 * @author by bobo
 * @Description
 * @Date 2022/11/27 11:37
 */
public class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode point1 = head, point2 = head;
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(13);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = new Solution().removeNodes(listNode1);

    }
}

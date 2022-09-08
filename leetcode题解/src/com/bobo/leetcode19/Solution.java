package com.bobo.leetcode19;

import com.bobo.LeetCode21.ListNode;

/**
 * @author by bobo
 * @Description leetcode 19 删除链表的倒数第N个节点
 * @Date 2022/9/5 10:14 AM
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slowPoint = dummyNode;
        ListNode quickPoint = head;
        for (int i = 0; i < n; i++) {
            quickPoint = quickPoint.next;
        }
        while (quickPoint != null ) {
            quickPoint = quickPoint.next;
            slowPoint = slowPoint.next;
        }
        //删除节点
        slowPoint.next = slowPoint.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);

        new Solution().removeNthFromEnd(listNode1, 1);
    }
}

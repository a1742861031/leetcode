package com.bobo.LeetCode876;

import com.bobo.LeetCode21.ListNode;

/**
 * @author by bobo
 * @Description 链表的中间节点
 * @Date 2022/7/6 9:16 AM
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        count = count/2+1;
        ListNode cur2 = head;
        for (int i = 1; i < count; i++) {
            cur2 = cur2.next;
        }
        return cur2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.middleNode(node1);
    }
}

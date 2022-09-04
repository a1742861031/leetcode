package com.bobo.leetcode142;

import com.bobo.LeetCode21.ListNode;


/**
 * @author by bobo
 * @Description 环形链表 II
 * @Date 2022/7/6 9:29 AM
 */
public class Solution {
    /**
     * 用快慢指针
     * 快指针走两格 慢指针走一格
     * 当链表有环时，他们肯定会相遇的
     * 然后通过
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                //只要有环 就会相遇
                ListNode ptr = head;
                //判断是在哪个地方相遇
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Solution solution = new Solution();
        solution.detectCycle(node1);
    }
}

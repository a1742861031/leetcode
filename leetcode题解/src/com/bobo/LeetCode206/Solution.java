package com.bobo.LeetCode206;

import com.bobo.LeetCode21.ListNode;

/**
 * @author by bobo
 * @Description LeetCode206 反转链表
 * @Date 2022/7/5 10:32 AM
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        }
        ListNode cur1 = null;
        ListNode cur2 = head;
        while (cur2 != null) {
            ListNode next = cur2.next;
            cur2.next = cur1;
            cur1 = cur2;
            cur2 = next;
        }
        return cur1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        Solution solution = new Solution();
        solution.reverseList(node1);
    }
}

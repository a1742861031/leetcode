package com.bobo.leetcode24;

/**
 * @author by bobo
 * @Description 迭代法解决
 * @Date 2022/8/8 10:32 AM
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;

        while (cur != null && cur.next != null&&cur.next.next!=null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            ListNode temp1 = cur.next.next.next;
            cur.next = node2;
            node2.next = node1;
            node1.next = temp1;
            cur = cur.next.next;
        }
        return dummyNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution2 solution = new Solution2();
        ListNode listNode = solution.swapPairs(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

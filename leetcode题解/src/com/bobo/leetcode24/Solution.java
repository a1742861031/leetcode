package com.bobo.leetcode24;

/**
 * @author by bobo
 * @Description leetcode24题 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 所以只能改变链表的指向
 * @Date 2022/8/8 9:48 AM
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //交换链表的两个节点
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

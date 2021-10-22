package com.bobo.leetcode02;

/**
 * @Description 两数相加
 * @Date 2021/10/22 18:16
 * @Created by bobo
 */


public class LeetCode02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        LeetCode02 leetCode02 = new LeetCode02();
        ListNode head = leetCode02.addTwoNumbers(node1, node2);
    }
    public static int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //非空链表l1,l2
        ListNode head = new ListNode();
        carry = 0;
        if (l1.val + l2.val >= 10) {
            head.next = new ListNode(l1.val + l2.val - 10);
            carry += 1;
        } else {
            head.next = new ListNode(l1.val + l2.val);
        }
        ListNode cur = head.next;
        while (l1.next != null || l2.next != null) {
            int temp1 = 0;
            int temp2 = 0;
            int temp;
            if (l1.next != null) {
                l1 = l1.next;
                temp1 = l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                temp2 = l2.val;
            }
            temp = temp1 + temp2 + carry;
            carry = 0;
            if (temp >= 10) {
                temp -= 10;
                cur.next = new ListNode(temp);
                carry += 1;
            } else {
                cur.next = new ListNode(temp);
            }
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}

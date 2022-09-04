package com.bobo.LeetCode21;

/**
 * @author by bobo
 * @Description 单链表的定义
 * @Date 2022/7/5 9:12 AM
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
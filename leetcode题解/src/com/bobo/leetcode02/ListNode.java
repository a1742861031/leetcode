package com.bobo.leetcode02;

/**
 * @Description 链表节点数据结构
 * @Date 2021/10/22 19:12
 * @Created by bobo
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
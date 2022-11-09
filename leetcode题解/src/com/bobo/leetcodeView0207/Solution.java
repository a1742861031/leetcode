package com.bobo.leetcodeView0207;

import com.bobo.LeetCode21.ListNode;

/**
 * @author by bobo
 * @Description 链表相交
 * @Date 2022/11/1 09:22
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}

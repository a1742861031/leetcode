package com.bobo.LeetCode876;

import com.bobo.LeetCode21.ListNode;

/**
 * @author by bobo
 * @Description leetcode 876 删除链表的中间节点
 * @Date 2022/9/5 9:59 AM
 */
public class Solution2 {
    public ListNode middleNode(ListNode head) {
        ListNode slowPoint = head;
        ListNode quickPoint = head;
        while ( quickPoint.next != null && quickPoint.next.next != null){
            quickPoint = quickPoint.next.next;
            slowPoint = slowPoint.next;
        }
        if (quickPoint.next != null) {
            slowPoint = slowPoint.next;
        }
        return slowPoint;
    }

    public static void main(String[] args) {

    }
}

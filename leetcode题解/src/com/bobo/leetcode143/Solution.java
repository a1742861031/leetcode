package com.bobo.leetcode143;

import com.bobo.LeetCode21.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description 重排链表
 * @Date 2022/11/10 09:43
 */
public class Solution {
    public void reorderList(ListNode head) {
        //采用List存储链表的每个节点
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int left = 1, right = list.size()-1;
        int index = 1;
        ListNode temp = head;
        while (left <= right) {
            if (index % 2 == 0) {
                temp.next = list.get(left);
                left++;
                temp = temp.next;

            }
            else {
                temp.next = list.get(right);
                right--;
                temp = temp.next;
            }
            index++;
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        new Solution().reorderList(node1);
    }
}

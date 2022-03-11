package com.bobo.offer;

import java.util.ArrayList;

/**
 * @Description 剑指 Offer 24. 反转链表
 * @Date 2022/3/11 11:28 PM
 * @Created by bobo
 */
public class Offer24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        //添加节点
        private void add(int data) {
            if (this.next == null) {
                this.next = new ListNode(data);        //如果当前节点的next为null,直接创建一个新的节点
            } else {
                this.next.add(data);            //否则进行递归调用，直到最后在某个为空的节点创建一个新节点
            }
        }

    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(head.val);
            while (head.next != null) {
                arr.add(head.next.val);
                head = head.next;
            }
        }
    }
}

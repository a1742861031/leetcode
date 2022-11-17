package com.bobo.leetcode02;

/**
 * @Description 两数相加
 * @Date 2021/10/22 18:16
 * @Created by bobo
 */


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansList = new ListNode();
        ListNode ans = ansList;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int pass = 0;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                while (cur2 != null) {
                    ansList.val = (cur2.val + pass) % 10;
                    pass = (cur2.val + pass) / 10;
                    ansList.next = new ListNode();
                    ansList = ansList.next;
                    cur2 = cur2.next;
                }

                break;
            }
            if (cur2 == null) {
                while (cur1 != null) {
                    ansList.val = (cur1.val + pass) % 10;
                    pass = (cur1.val + pass) / 10;
                    ansList.next = new ListNode();
                    ansList = ansList.next;
                    cur1 = cur1.next;
                }

                break;
            }
            int add = cur1.val + cur2.val;
            if (add >= 10) {
                ansList.val = (add  + pass)%10;
                pass = (add + pass) / 10;
                ansList.next = new ListNode();
                ansList = ansList.next;

            } else {
                ansList.val = (add  + pass)%10;
                pass = (add + pass) / 10;
                ansList.next = new ListNode();
                ansList = ansList.next;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;

        }

        ListNode temp = ans;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        if (pass != 0) {
            temp.next = new ListNode(pass);
        } else {
            temp.next = null;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(9);
        ListNode node17 = new ListNode(9);
        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        ListNode listNode = new Solution().addTwoNumbers(node11, node21);
        System.out.println(listNode);
    }


}

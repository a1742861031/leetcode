package com.bobo.leetcode116;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author by bobo
 * @Description leetcode 116 填充每个节点的下一个右侧节点指针
 * @Date 2022/9/9 10:29 AM
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<List<Node>> answer = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            List<Node> currentFloor = new ArrayList<>();
            int nextSize = 0;
            while (size > 0) {
                Node treeNode = queue.remove();
                size--;
                //当前层的所有节点
                currentFloor.add(treeNode);
                //左右孩子加入队列
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    nextSize++;
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    nextSize++;
                }
            }
            answer.add(currentFloor);
            size = nextSize;
        }
        for (List<Node> nodes : answer) {
            for (int i = 0; i < nodes.size() - 1; i++) {
                nodes.get(i).next = nodes.get(i + 1);
            }
            nodes.get(nodes.size() - 1).next = null;
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        //循环的终止条件，当前节点的left节点为空
        //注意这是一个完美二叉树，所以循环终止条件才如此
        while (pre.left != null) {
            //tmp节点为当前节点的左节点
            Node tmp = pre;
            while (tmp != null) {
                //连接当前节点的左右子节点
                tmp.left.next = tmp.right;
                //tmp节点的右边也有节点时，这时让tmp节点的有节点的左节点指向tmp的下一个节点的左节点
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                //tmp节点继续向右
                tmp = tmp.next;
            }
            //往下一层
            pre = pre.left;
        }
        return root;
    }

    public Node connect2(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node current) {
        if (current == null) {
            return;
        }
        Node left = current.left;
        Node right = current.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(current.left);
        dfs(current.right);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Node connect = new Solution().connect2(node1);
    }
}

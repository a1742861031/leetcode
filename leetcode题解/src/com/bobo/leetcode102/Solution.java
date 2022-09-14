package com.bobo.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author by bobo
 * @Description 102. 二叉树层序遍历
 * @Date 2022/7/8 1:49 PM
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> currentFloor = new ArrayList<>();
            int nextSize = 0;
            while (size > 0) {
                TreeNode treeNode = queue.remove();
                size--;
                //当前层的所有节点
                currentFloor.add(treeNode.val);
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
        return answer;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        List<List<Integer>> lists = new Solution().levelOrder(node1);
    }
}

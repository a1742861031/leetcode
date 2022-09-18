package com.bobo.leetcode111;

import com.bobo.leetcode102.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by bobo
 * @Description leetcode 111 二叉树的最小深度
 * @Date 2022/9/15 14:21
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int answer = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            int nextSize = 0;
            while (size > 0) {
                TreeNode node = queue.remove();
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                    nextSize++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextSize++;
                }
                if (node.left == null && node.right == null) {
                    return answer;
                }
            }
            size = nextSize;
            answer++;
        }
        return answer;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int m1 = minDepth1(root.left);
        int m2 = minDepth1(root.right);
        if (m1 == 0 || m2 == 0) {
            return m1 + m2 + 1;
        }
        return Math.min(m1,m2)+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(new Solution().minDepth(node1));
    }
}

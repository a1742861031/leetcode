package com.bobo.leetcode104;

import com.bobo.leetcode102.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by bobo
 * @Description leetcode 104 二叉树的最大深度
 * @Date 2022/9/14 8:11 PM
 */
public class Solution {
    public int maxDepth1(TreeNode root) {
        //终止条件
        if (root == null) {
            return 0;
        }
        int leftLen = maxDepth1(root.left);
        int rightLen = maxDepth1(root.right);
        return Math.max(leftLen,rightLen)+1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int answer = 0;
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
            }
            size = nextSize;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(17);
        node1.left = node2;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        int i = new Solution().maxDepth1(node1);
        System.out.println(i);
    }
}

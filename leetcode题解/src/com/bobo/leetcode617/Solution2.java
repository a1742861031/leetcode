package com.bobo.leetcode617;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by bobo
 * @Description 广度优先
 * @Date 2022/9/8 12:07 PM
 */
public class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        //特殊条件判断
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        //根节点入队列
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();
            //合并两个节点
            node1.val += node2.val;
            //左节点入队列
            if (node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
            } //如果当前树1节点左节点为空，直接赋树2的左节点
             else if (node1.left == null) {
                node1.left = node2.left;
            }
            //右节点入队列
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            //如果当前树1节点右节点为空，直接赋树2的右节点
            else if (node1.right == null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

    public static void main(String[] args) {

    }
}

package com.bobo.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description 二叉树 前中后序遍历
 * @Date 2022/9/8 2:55 PM
 */
public class Ergodic {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrderDfs(root,ans);
        return ans;
    }

    public void preOrderDfs(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        array.add(root.val);
        preOrderDfs(root.left, array);
        preOrderDfs(root.right, array);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderDfs(root,ans);
        return ans;
    }

    private void postOrderDfs(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        postOrderDfs(root.left, array);
        postOrderDfs(root.right, array);
        array.add(root.val);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderDfs(root,ans);
        return ans;
    }

    private void inOrderDfs(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        inOrderDfs(root.left, array);
        array.add(root.val);
        inOrderDfs(root.right, array);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        List<Integer> ans = new Ergodic().preorderTraversal(node1);
    }
}

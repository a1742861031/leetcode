package com.bobo.leetcode257;

import com.bobo.leetcode102.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description leetcode257 二叉树的所有路径
 * @Date 2022/11/23 09:35
 */
public class Solution {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        preDfs(root, "", paths);
        return paths;
    }

    public void preDfs(TreeNode root, String s, List<String> paths) {
        StringBuilder str = new StringBuilder(s);
        if (root != null) {
            str.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(str.toString());
            } else {
                str.append("->");
                preDfs(root.left, str.toString(), paths);
                preDfs(root.right, str.toString(), paths);

            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(new Solution().binaryTreePaths(treeNode1));
    }
}

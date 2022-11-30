package com.bobo.leetcode700;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode700 二叉搜索树的搜索
 * @Date 2022/11/24 09:22
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public TreeNode preDef(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        if (node.val > val) {
            preDef(node.left, val);
        } else {
            preDef(node.right, val);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

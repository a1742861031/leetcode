package com.bobo.leetcode106;

import com.bobo.leetcode102.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode106  从中序与后序遍历序列构造二叉树
 * @Date 2022/12/2 09:14
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        //找到中序的Index
        int inIndex = map.get(rootVal);
        postIndex--;
        root.right = buildSubTree(inIndex + 1, inRight);
        root.left = buildSubTree(inLeft, inIndex - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        new Solution().buildTree(inorder,postorder);
    }
}

package com.bobo.offer.offer07;

import com.bobo.leetcode102.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description 剑指 Offer 07. 重建二叉树
 * @Date 2022/12/9 09:57
 */
public class Solution {
    Map<Integer, Integer> indexMap;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildMyTree(int preLeft, int preRight, int inOrderLeft, int inOrderRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootIndex = preLeft;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int inOrderIndex = indexMap.get(preorder[rootIndex]);
        int size = inOrderIndex - inOrderLeft;
        root.left = buildMyTree(preLeft + 1, preLeft + size, inOrderLeft, inOrderIndex - 1);
        root.right = buildMyTree(preLeft + size + 1, preRight, inOrderIndex + 1, inOrderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        new Solution().buildTree(preorder,inorder);
    }
}

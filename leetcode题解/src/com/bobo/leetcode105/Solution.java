package com.bobo.leetcode105;

import com.bobo.leetcode102.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description 从前序与中序遍历序列构造二叉树
 * @Date 2022/12/1 08:45
 */
public class Solution {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //构建中序遍历结果和对应下表的hash表
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildSubTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inOrderLeft, int inOrderRight) {
        if (preLeft > preRight) {
            return null;
        }
        //前序的left节点就是root节点
        int preorderRoot = preLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        Integer inOrderRoot = indexMap.get(preorder[preorderRoot]);
        int size = inOrderRoot - inOrderLeft;
        root.left = buildSubTree(preorder, inorder, preLeft + 1, preLeft + size, inOrderLeft, inOrderRoot - 1);
        root.right = buildSubTree(preorder, inorder, preLeft + size + 1, preRight, inOrderRoot + 1, inOrderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        new Solution().buildTree(preOrder, inOrder);
    }
}

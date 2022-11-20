package com.bobo.week.week320.test02;


import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description 6242. 二叉搜索树最近节点查询
 * @Date 2022/11/20 10:36
 */
public class Solution {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer query : queries) {
            int[] ints = find(query, root);
            List<Integer> cur = new ArrayList<>();
            cur.add(ints[0] == Integer.MIN_VALUE ? -1 : ints[0]);
            cur.add(ints[1] == Integer.MAX_VALUE ? -1 : ints[1]);
            ans.add(cur);
        }
        return ans;
    }

    public int[] find(int data, TreeNode root) {
        int[] cur = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        TreeNode now = root;
        while (now != null) {
            if (data > now.val) {
                cur[0] = Math.max(cur[0], now.val);
                now = now.right;
            } else if (data < now.val) {
                cur[1] = Math.min(cur[1], now.val);
                now = now.left;
            } else {
                cur[0] = now.val;
                cur[1] = now.val;
                return cur;
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(13);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        List<Integer> query = new ArrayList<>();
        query.add(2);
        query.add(5);
        query.add(16);
        List<List<Integer>> lists = solution.closestNodes(treeNode1, query);
        System.out.println(lists);
    }


}

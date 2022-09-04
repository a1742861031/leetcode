package com.bobo.LeetCode589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description LeetCode589 N 叉树的前序遍历
 * @Date 2022/7/7 10:04 AM
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }

    public void recursion(Node root, List<Integer> ans) {
        ans.add(root.val);
        for (Node child : root.children) {
            recursion(child, ans);
        }
    }
}

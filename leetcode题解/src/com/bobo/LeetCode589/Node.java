package com.bobo.LeetCode589;

import java.util.List;

/**
 * @author by bobo
 * @Description N插数
 * @Date 2022/7/7 10:04 AM
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

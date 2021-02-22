package com.leetcode.easy;

public class BinaryTree {
    
    public TreeNode createNode(int val){
        TreeNode node = new TreeNode(val);
        return node;
    }

    public TreeNode createNode(int val, TreeNode left, TreeNode right){
        TreeNode node = new TreeNode(val, left, right);
        return node;
    }
    
}

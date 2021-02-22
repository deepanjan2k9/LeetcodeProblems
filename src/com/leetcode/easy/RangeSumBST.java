package com.leetcode.easy;

public class RangeSumBST {
    int sum = 0;
    

    public static BinaryTree populateBST(BinaryTree binaryTree){
        TreeNode root = binaryTree.createNode(10);
        root.left.val = 5;
        root.right.val = 15;
        root.left.left.val = 3;
        root.left.right.val = 7;
        root.right.right.val = 18;

        return binaryTree;
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree = populateBST(binaryTree);
        

    }
    
}

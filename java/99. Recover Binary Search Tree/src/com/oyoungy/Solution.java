package com.oyoungy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private TreeNode first, middle, last, prev;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        swapVal(first, last != null ? last: middle);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prev != null && root.val < prev.val) {
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }

    public void swapVal(TreeNode n1, TreeNode n2){
        n1.val = n1.val^n2.val;
        n2.val = n1.val^n2.val;
        n1.val = n1.val^n2.val;
    }
}
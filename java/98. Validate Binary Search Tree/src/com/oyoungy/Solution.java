package com.oyoungy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ans.isValidBST(new TreeNode(9));
        System.out.println();
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }
    private boolean isValidBST(TreeNode root, long lower, long upper){
        if(root==null) return true;
        if((root.left==null || (root.val>root.left.val&&root.left.val>lower)) && (root.right==null || (root.val<root.right.val&&root.right.val<upper))){
            return isValidBST(root.left, lower, root.val)&&isValidBST(root.right, root.val, upper);
        }
        return false;
    }
}
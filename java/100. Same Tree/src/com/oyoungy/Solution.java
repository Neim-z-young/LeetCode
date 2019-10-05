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
        System.out.println();
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q!=null && p.val==q.val){
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        }
        return false;
    }
}
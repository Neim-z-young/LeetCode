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

    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode left = root.left, right = root.right, temp = left==null?root:left;
        flatten(left);
        root.left = null;
        root.right = left;
        if(left!=null){
            while (temp.right!=null){  //减少遍历次数
                temp = temp.right;
            }
        }
        temp.right = right;
        flatten(right);
    }
}
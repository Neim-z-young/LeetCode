package com.oyoungy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    private TreeNode constructTree(int[] inorder, int inS, int inE,int[] postorder, int postS, int postE ){
        if(postorder==null || postS>=postE) return null;
        TreeNode root =  new TreeNode(postorder[postE-1]);
        root.left = null;
        root.right = null;
        if(postE==postS+1){
            return root;
        }
        int i = inS;
        for(; i<inE; i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        root.right = constructTree(inorder, i+1, inE, postorder, postS+i-inS, postE-1);
        root.left = constructTree(inorder, inS, i, postorder, postS, postS+i-inS);
        return root;
    }
}
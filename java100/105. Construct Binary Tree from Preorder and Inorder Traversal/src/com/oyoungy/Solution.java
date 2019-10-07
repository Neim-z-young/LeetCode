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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private TreeNode constructTree(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preorder==null || preS>=preE) return null;
        TreeNode root =  new TreeNode(preorder[preS]);
        root.left = null;
        root.right = null;
        if(preE==preS+1){
            return root;
        }
        int i = inS;
        for(; i<inE; i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        root.left = constructTree(preorder, preS+1, preS+i-inS+1, inorder, inS, i);
        root.right = constructTree(preorder, preS+i-inS+1, preE, inorder, i+1, inE);
        return root;
    }
}
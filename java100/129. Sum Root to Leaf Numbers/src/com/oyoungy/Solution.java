package com.oyoungy;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    private int total = 0;
    public int sumNumbers(TreeNode root) {
        total = 0;
        sumNumbers(root, 0);
        return total;
    }
    private void sumNumbers(TreeNode root, int value){
        if(root==null){
            return ;
        }
        int temp = root.val+value*10;
        if(root.left==null && root.right==null){
            total += temp;
        }else {
            if(root.left!=null){
                sumNumbers(root.left, temp);
            }
            if(root.right!=null){
                sumNumbers(root.right, temp);

            }
        }
    }
}
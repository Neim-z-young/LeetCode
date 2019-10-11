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
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverseTree(root);
        return maxPath;
    }
    private int traverseTree(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        int left = traverseTree(root.left);
        int right = traverseTree(root.right);
        int temp = left;
        if(left<0){
            temp=right;
            if(right<0){
                temp = root.val;
            }else {
                if(root.val>0){
                    temp+=root.val;
                }
            }
        }else {
            if(right<0){
                if(root.val>0){
                    temp+=root.val;
                }
            }else {
                int bigger = Math.max(left, right), smaller = bigger==left?right:left;
                temp = bigger;
                if(smaller+root.val>0){
                    temp += (smaller+root.val);
                }
            }
        }
        if (temp > maxPath) {
            maxPath = temp;
        }
        int t1 = Math.max(left, right); //越界检查
        return Math.max((t1==Integer.MIN_VALUE?0:t1)+root.val, root.val);
    }
}
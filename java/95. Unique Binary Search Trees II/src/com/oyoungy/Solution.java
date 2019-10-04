package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        return generateTrees(nums, 0, n);
    }
    private List<TreeNode> generateTrees(int[] nums, int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        for(int i = start; i<end; i++){
            List<TreeNode> lefts = generateTrees(nums, start, i);
            List<TreeNode> rights = generateTrees(nums, i+1, end);
            if(lefts.size()==0 && rights.size()==0){
                ans.add(new TreeNode(nums[start]));
            }else if(lefts.size()==0){
                for(TreeNode right:rights){
                    TreeNode root  = new TreeNode(nums[i]);
                    root.left = null;
                    root.right = right;
                    ans.add(root);
                }
            }else if(rights.size()==0){
                for(TreeNode left:lefts){
                    TreeNode root  = new TreeNode(nums[i]);
                    root.left = left;
                    root.right = null;
                    ans.add(root);
                }
            }else {
                for (TreeNode left:lefts){
                    for(TreeNode right:rights){
                        TreeNode root  = new TreeNode(nums[i]);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
}
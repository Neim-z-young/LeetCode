package com.oyoungy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                int count = queue.size();
                while (count>0){
                    TreeNode tNode = queue.poll();
                    temp.add(tNode.val);
                    if(tNode.left!=null){
                        queue.add(tNode.left);
                    }
                    if(tNode.right!=null){
                        queue.add(tNode.right);
                    }
                    count--;
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
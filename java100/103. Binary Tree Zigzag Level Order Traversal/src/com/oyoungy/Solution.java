package com.oyoungy;

import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root!=null){
            Deque<TreeNode> queue = new LinkedList();
            queue.add(root);
            boolean reverse = false;
            while (!queue.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                int count = queue.size();
                while (count>0){
                    TreeNode tNode;
                    if(reverse) {
                        tNode = queue.pollFirst();
                        if(tNode.right!=null){
                            queue.addLast(tNode.right);
                        }
                        if(tNode.left!=null){
                            queue.addLast(tNode.left);
                        }
                    }else {
                        tNode = queue.pollLast();
                        if(tNode.left!=null){
                            queue.addFirst(tNode.left);
                        }
                        if(tNode.right!=null){
                            queue.addFirst(tNode.right);
                        }
                    }
                    temp.add(tNode.val);
                    count--;
                }
                reverse = !reverse;
                ans.add(temp);
            }
        }
        return ans;
    }
}
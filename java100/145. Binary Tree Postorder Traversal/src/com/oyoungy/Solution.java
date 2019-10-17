package com.oyoungy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root==null) return list;
        Stack<TreeNode> travelStack = new Stack<>();
        travelStack.push(root);
        while (!travelStack.empty()){
            TreeNode node = travelStack.pop();
            list.add(0, node.val);
            if(node.left!=null){
                travelStack.push(node.left);
            }
            if(node.right!=null){
                travelStack.push(node.right);
            }
        }
        return list;
    }
}
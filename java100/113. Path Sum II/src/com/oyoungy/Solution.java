package com.oyoungy;

import java.util.LinkedList;
import java.util.List;

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {

        }else if(root.left==null && root.right==null && root.val==sum){
            List<Integer> t = new LinkedList<>();
            t.add(root.val);
            ans.add(t);
        }else {
            List<List<Integer>> lefts = pathSum(root.left, sum - root.val), rights = pathSum(root.right, sum - root.val);
            for (List list : lefts) {
                list.add(0, root.val);
                ans.add(list);
            }
            for(List list:rights){
                list.add(0, root.val);
                ans.add(list);
            }
        }
        return ans;
    }
}
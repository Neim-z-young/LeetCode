package com.oyoungy;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * using left subTree stack
 */
class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if(root!=null){
            TreeNode tmp = root;
            while (tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        int val = tmp.val;
        tmp = tmp.right;
        while (tmp!=null){
            stack.push(tmp);
            tmp = tmp.left;
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>0;
    }
}

/**
 * using recursive, time : 1761ms
 */
class BSTIterator1 {
    private TreeNode root;
    private BSTIterator lIterator, rIterator;
    boolean read;

    public BSTIterator1(TreeNode root) {
        this.root = root;
        if(root!=null){
            lIterator = new BSTIterator(root.left);
            rIterator = new BSTIterator(root.right);
            read = false;
        }else {
            lIterator = null;
            rIterator = null;
            read = true;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if(lIterator!=null && lIterator.hasNext()) return lIterator.next();
        if(read &&rIterator!=null) return rIterator.next();
        read = true;
        return root.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root==null) return false;
        if(lIterator!=null&&lIterator.hasNext()) return true;
        if(!read) return true;
        return rIterator != null && rIterator.hasNext();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
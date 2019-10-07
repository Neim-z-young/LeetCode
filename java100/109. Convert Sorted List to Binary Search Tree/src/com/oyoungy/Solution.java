package com.oyoungy;

import com.sun.source.tree.Tree;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
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
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, head, null);
    }
    private TreeNode sortedListToBST(ListNode head, ListNode start, ListNode end) {
        if(head==null || start==end){
            return null;
        }
        ListNode mid = start, doubleMid = start.next;
        while (doubleMid!=end){
            mid = mid.next;
            doubleMid = doubleMid.next;
            if(doubleMid!=end){
                doubleMid = doubleMid.next;
            }
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head, start, mid);
        root.right = sortedListToBST(head, mid.next, end);
        return root;
    }
}
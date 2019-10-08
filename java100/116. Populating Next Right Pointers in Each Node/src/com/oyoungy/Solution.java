package com.oyoungy;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> levelQueue = new LinkedList();
        levelQueue.add(root);
        while (levelQueue.size()>0){
            Node pre = null;
            int count = levelQueue.size();
            while (count-->0){
                if(pre!=null){
                    pre.next = levelQueue.peek();
                }
                pre = levelQueue.poll();
                if(pre.left!=null){
                    levelQueue.add(pre.left);
                }
                if(pre.right!=null){
                    levelQueue.add(pre.right);
                }
            }
        }
        return root;
    }
}
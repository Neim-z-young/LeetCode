package com.oyoungy;

import java.util.HashMap;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    HashMap<Integer, Node> sets = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node h = sets.get(head.val);
        if(h!=null) return h;
        h = new Node(head.val, null, null);
        sets.put(head.val, h);
        h.next = copyRandomList(head.next);
        h.random = copyRandomList(head.random);
        return h;
    }
}
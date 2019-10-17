package com.oyoungy;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next =new ListNode(3);
        head.next.next.next =new ListNode(4);
        head.next.next.next.next =new ListNode(5);
        ans.reorderList(head);
        System.out.println();
    }
    //
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> nodePosition = new HashMap<>(); //using ArrayList may be better
        ListNode p = head;
        int max = 0, cur = 0;
        while (p!=null){
            nodePosition.put(++max, p);
            p=p.next;
        }
        p = head;
        while (++cur<max){
            ListNode last = nodePosition.get(max--);
            nodePosition.get(max).next = null;
            last.next = p.next;
            p.next = last;
            p = last.next;
        }
    }
}
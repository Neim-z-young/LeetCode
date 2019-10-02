package com.oyoungy;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode ph = head, p = head.next, newh = new ListNode(0), php = newh;
        newh.next = head;
        while (p!=null){
            if(p.val!=ph.val){
                php = ph;
            }else {
                while (p!=null && p.val==ph.val){
                    p=p.next;
                }
                if(php!=null){
                    php.next = p;
                }
            }
            if(p==null){
                break;
            }
            ph = p;
            p = p.next;
        }
        return newh.next;
    }
}
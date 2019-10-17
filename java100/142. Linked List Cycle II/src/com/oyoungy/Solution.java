package com.oyoungy;

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
        System.out.println();
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode p = head, twoP = head.next;
        while (twoP!=null){
            if(p==twoP){
                twoP = twoP.next;
                p = head;
                while (p!=twoP){
                    p=p.next;
                    twoP = twoP.next;
                }
                return p;
            }
            p=p.next;
            if((twoP = twoP.next)==null){
                break;
            }
            twoP = twoP.next;
        }
        return null;
    }
}
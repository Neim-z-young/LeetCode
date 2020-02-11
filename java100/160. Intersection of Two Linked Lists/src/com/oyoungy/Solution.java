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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode h1 = headA, h2 = headB;
        int count = 0;
        while (h1!=h2){
            h1 = h1.next;
            h2 = h2.next;
            if(h1 == null){
                h1 = headB;
                if(count++==2)
                    return null;
            }
            if(h2 == null){
                h2 = headA;
            }
        }
        return h1;
    }
}
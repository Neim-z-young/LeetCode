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
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode p = head, twoP = head.next;
        while (twoP!=null){
            if(p==twoP){
                return true;
            }
            p=p.next;
            if((twoP = twoP.next)==null){
                break;
            }
            twoP = twoP.next;
        }
        return false;
    }
}
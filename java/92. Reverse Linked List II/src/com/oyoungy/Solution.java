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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        ListNode tempHead = new ListNode(0), ph = tempHead, p = head;
        tempHead.next = head;
        int count = 1;
        while (p!=null){
            if(count==m){
                ListNode pn = p.next, pnp=p;
                while (pn!=null && count<=n){
                    pnp.next = pn.next;
                    pn.next = p;
                    p = pn;
                    pn = pnp.next;
                    count++;
                }
                ph.next = p;
                break;
            }
            ph = ph.next;
            p = p.next;
            count++;
        }
        return tempHead.next;
    }
}
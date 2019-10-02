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
        ListNode ph = head, p = ph.next;
        while (p!=null){
            while (p!=null && p.val==ph.val){
                p = p.next;
            }
            ph.next = p;
            if(p==null){
                break;
            }
            ph = p;
            p = ph.next;
        }
        return head;
    }
}
package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val) return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
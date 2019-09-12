package com.oyoungy;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        int count = 0;
        ListNode ph = head;
        while (ph!=null){
            ph=ph.next;
            count++;
        }
        k%=count;
        if(k!=0){
            int remain = count-k;
            ph = head;
            while (--remain>0){
                ph = ph.next;
            }
            ListNode newHead = ph.next;
            ph.next = null;
            ph = newHead;
            while (ph.next!=null){
                ph = ph.next;
            }
            ph.next = head;
            head = newHead;
        }
        return head;
    }
}
package com.oyoungy;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class  Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public ListNode reverseList(ListNode head) {
        ListNode tmp, newL = null;
        while (head!=null){
            tmp = head;
            head = head.next;
            tmp.next = newL;
            newL = tmp;
        }
        return newL;
    }
}
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
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail){
        if(head==tail){
            return head;
        }
        ListNode t = head.next, leftH = head, rightH = tail;
        while (t!=tail){ //partition
            ListNode tp = t.next;
            if(t.val<head.val){
                t.next = leftH;
                leftH = t;
            }else {
                t.next = rightH;
                rightH = t;
            }
            t = tp;
        }
        ListNode ans = sortList(leftH, head);
        head.next = sortList(rightH, tail);
        return ans;
    }
}
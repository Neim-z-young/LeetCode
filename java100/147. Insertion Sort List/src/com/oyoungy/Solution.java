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
    public ListNode insertionSortList(ListNode head) {
        ListNode tHead = new ListNode(0), cur = null, tail = head;
        //tail标记已排序元素的尾部
        tHead.next = head;
        if(head!=null){
            cur = head.next;
        }
        while (cur!=null){
            ListNode t = tHead;
            while (t!=tail && t.next.val<cur.val){
                t = t.next;
            }
            if(t==tail){
                tail = cur;
            }else{
                tail.next = cur.next;
                cur.next = t.next;
                t.next = cur;
            }
            cur = tail.next;
        }
        return tHead.next;
    }
}
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);
        ans.partition(l1, 2);
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pNode = new ListNode(0), ph = pNode, p = head, pp;
        pNode.next = head;
        while (p!=null && !((ph == pNode || ph.val < x) && p.val >= x)) {
            ph = ph.next;
            p = ph.next;
        }
        pp = ph;
        while (p != null) {
            while (p != null && p.val >= x) {
                pp = pp.next;
                p = p.next;
            }
            if (p == null) {
                break;
            }
            pp.next = p.next;
            p.next = ph.next;
            ph.next = p;

            p = pp.next;
            ph = ph.next;
        }
        return pNode.next;
    }
}
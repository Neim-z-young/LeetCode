# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        ans=ListNode(0)
        temp=ans
        carry=0
        while l1 or l2:
            x=l1.val if l1 else 0
            y=l2.val if l2 else 0
            sums=x+y+carry
            carry=sums//10
            rest=sums%10
            temp.next=ListNode(rest)
            temp=temp.next
            l1=l1.next if l1 else None
            l2=l2.next if l2 else None
        if carry>0:
            temp.next=ListNode(1)
            temp=temp.next        
        ans=ans.next
        return ans
            
        
        
        
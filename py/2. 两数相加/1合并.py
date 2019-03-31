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
        while l1 is not None and l2  is not None:
            sums=l1.val+l2.val+carry
            carry=sums//10
            rest=sums%10
            temp.next=ListNode(rest)
            temp=temp.next
            l1=l1.next
            l2=l2.next

        if l1 is None:
            while l2 is not None :
                sums=l2.val+carry
                carry=sums//10
                rest=sums%10
                temp.next = ListNode(rest)
                temp=temp.next
                l2=l2.next

        if l2 is None:
            while l1 is not None :
                sums=l1.val+carry
                carry=sums//10
                rest=sums%10
                temp.next = ListNode(rest)
                temp=temp.next
                l1=l1.next
        if carry>0:
            temp.next=ListNode(1)
            temp=temp.next
        
        ans=ans.next
        return ans
            
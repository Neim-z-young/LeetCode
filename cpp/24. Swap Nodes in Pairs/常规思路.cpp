#include<iostream>
using namespace std;
/**
 * Definition for singly-linked list.
*/
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(!head) return NULL;
        if(!head->next) return head;
        ListNode* ansNext = new ListNode(0);
        ansNext->next = head;
        ListNode* temp1 = ansNext;
        ListNode* temp2 = head->next;
        ListNode* t2Next; 
        ListNode* swap;
        while(temp2){
            t2Next = temp2->next;
            swap =temp1->next;
            temp1->next = temp2;
            temp1->next->next = swap;
            swap->next = t2Next;
            if(!t2Next)
                break;
            temp1 = swap;
            temp2 = t2Next->next;
        }
        return ansNext->next;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    int a[]={1,2,3,4,5};
    int len = sizeof(a)/sizeof(int);
    ListNode* head = new ListNode(1);
    ListNode* temp=head;
    for(int i=1; i<len; i++){
        temp->next = new ListNode(a[i]);
        temp = temp->next;
    }
    ans.swapPairs(head);
    return 0;
}

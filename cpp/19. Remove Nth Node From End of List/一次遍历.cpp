//一次遍历，不过时间复杂度和两次的差不多
//两次遍历
#include<iostream>
using namespace std;
/**
 * Definition for singly-linked list.
*/
#define NULL 0
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
void printList(ListNode* head){
    while(head){
        cout<<head->val<<"->";
        head=head->next;
    }
}
 
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head||!head->next) return NULL;
        ListNode* phead = new ListNode(0);
        phead->next = head;
        ListNode* first = phead;
        ListNode* second = phead;
        while(n>0){
            first=first->next;
            n--;
        }
        while(first->next){
            first=first->next;
            second=second->next;
        }
        second->next = second->next->next;
        return phead->next;
    }
};
int main(int argc, char const *argv[])
{
    int a[]={1,2,3,4,5};
    int len = sizeof(a)/sizeof(int);
    ListNode* head = new ListNode(1);
    ListNode* temp=head;
    for(int i=1; i<len; i++){
        temp->next = new ListNode(a[i]);
        temp = temp->next;
    }
    printList(head);
    cout<<'\n';
    Solution ans;
    printList(ans.removeNthFromEnd(head, 1));
    return 0;
}

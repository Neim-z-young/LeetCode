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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k==1||!head||!head->next) return head;
        ListNode* kth = head;
        int index = 1;
        while(index<k&&kth){
            kth = kth->next;
            index++;
        }
        if(!kth) return head;
        kth->next = reverseKGroup(kth->next, k);
        ListNode* first = recurWthinK(head, k);
        return first;
    }
private:
    ListNode* recurWthinK(ListNode* head, int k){
        if(k==1||!head||!head->next) return head;
        ListNode* first = head;
        ListNode* kth;
        ListNode* kthPre = head;
        int index = 1;
        while(index<k-1&&kthPre){
            kthPre = kthPre->next;
            index++;
        }
        if(!kthPre||!kthPre->next) return head;
        kth = kthPre->next;
        ListNode* temp = first->next;
        kthPre->next = first;
        first->next = kth->next;
        if(k>2)
            kth->next = recurWthinK(temp, k-2);
        else
            kth->next = first;
        return kth;
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
    ans.reverseKGroup(head, 2);
    
    return 0;
}

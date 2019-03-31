#include<iostream>
using namespace std;
//函数中只调用一次递归
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
        ListNode* first = head;
        ListNode* tempF = first;
        ListNode* tail = head;
        while(index>0){
            tempF = first;
            first = first->next;
            if(tempF!=head)
                tempF->next = head;
            head = tempF;
            index--;
        }
        tail->next = reverseKGroup(first, k);
        return head;
    }
};
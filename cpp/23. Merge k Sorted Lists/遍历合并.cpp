#include<vector>
#include<iostream>
using namespace std;
//time O(n*k)   space O(n)
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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int len = lists.size();
        if(len==0) return NULL;
        if(len==1) return lists[0];
        ListNode* ansPre = new ListNode(0);
        ListNode* temp = ansPre;
        while(1){
            int index=-1;
            int tempMin = INT32_MAX;
            for(int i=0; i<len; i++){
                if(lists[i]&&tempMin>lists[i]->val){
                    tempMin = lists[i]->val;
                    index = i;
                }
            }
            if(index==-1)
                return ansPre->next;
            temp->next = new ListNode(tempMin);
            temp = temp->next;
            lists[index] = lists[index]->next;
            
        }
        return ansPre->next;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}

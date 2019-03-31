//两次遍历
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
 
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int num = 0;
        if(!head) return NULL;
        ListNode* temp = head;
        while(temp!=NULL){
            temp = temp->next;
            num++;
        }
        int m = num-n;
        if(m==0) return head->next;
        temp =head;
        for(int i=0; i<m-1; i++){
            temp = temp->next;
        }
        temp->next = temp->next->next;
        return head;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}

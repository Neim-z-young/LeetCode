#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int len = nums.size();
        if(len<1) return len;
        int front = 0, tail = len-1;
        if(front==tail){
            if(nums[front]==val) return 0;
            else return 1;
        }
        while(front<tail){
            while(front<tail&&nums[front]!=val) front++;
            while(tail>front&&nums[tail]==val) tail--;
            int temp = nums[front];
            nums[front] = nums[tail];
            nums[tail] = temp;
        }
        if(nums[tail]==val)
            return front;
        else
            return front+1;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

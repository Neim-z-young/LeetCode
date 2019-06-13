#include<iostream>
#include<vector>
using namespace std;
//time O(n)  space O(1)
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int size = nums.size();
        for(int i=0; i<size; i++){
            int inx = i;
            while(nums[inx]!=inx+1&&nums[inx]<size+1&&nums[inx]>0){
                int tmp = nums[nums[inx]-1];
                //避免重复
                if(tmp==nums[inx]) break;
                nums[nums[inx]-1] = nums[inx];
                nums[inx] = tmp;
            }
        }
        int inx=0;
        while(inx<size){
            if(nums[inx]!=inx+1)
                break;
            inx++;
        }
        return inx+1;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.firstMissingPositive(vector<int>({3,4,-1,1,1}));
    return 0;
}

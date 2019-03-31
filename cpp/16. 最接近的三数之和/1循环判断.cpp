#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
//三层循环O(n^3)的时间复杂度，不理想
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int size = nums.size();
        if(size<3) return 0;
        sort(nums.begin(), nums.end());
        int min = nums[0]+nums[1]+nums[2];
        if(size==3) return min;
        for(int a = 0; a<size-2;){
            for(int b = a+1; b<size-1;){
                for(int c = b+1; c<size;){
                    if(abs(nums[a]+nums[b]+nums[c]-target)<abs(min-target))
                        min = nums[a]+nums[b]+nums[c];
                    do c++; while(c<size-1&&nums[c]==nums[c+1]);
                }
                do b++; while(b<size-2&&nums[b]==nums[b+1]);
            }
            do a++; while(a<size-3&&nums[a]==nums[a+1]);
        }
        return min;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.threeSumClosest(vector<int>({-1, 0, 1, 2, -1, -4}), 1);
    return 0;
}

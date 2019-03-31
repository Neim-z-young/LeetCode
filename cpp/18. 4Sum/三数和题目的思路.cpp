#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        int len = nums.size(), a=0;
        if(len<4) return ans;
        while(a<len-3){
            int b = a+1, temp3 = target-nums[a];
            while(b<len-2){
                int c = b+1, d = len-1, temp2 = temp3-nums[b];
                while(c<d){
                    if(nums[c]+nums[d] > temp2){
                        //reduce repeat d
                        do d--; while(d>c&&nums[d+1]==nums[d]);
                    }else{
                        if(nums[c]+nums[d] == temp2)
                            ans.push_back(vector<int>({nums[a], nums[b], nums[c], nums[d]}));
                        //reduce repeat c
                        do c++; while(c<d&&nums[c-1]==nums[c]);
                    }
                }
                //reduce repeat b
                do b++; while(b<len-2&&nums[b-1]==nums[b]);
            }
            //reduce repeat a
            do a++; while(a<len-3&&nums[a-1]==nums[a]);
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.fourSum(vector<int>({1, 0, -1, 0, -2, 2}), 0);
    return 0;
}

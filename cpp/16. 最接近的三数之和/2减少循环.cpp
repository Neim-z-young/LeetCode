#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
//二层循环O(n^2)的时间复杂度，并且减少重复值
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int size = nums.size();
        if(size<3) return 0;
        sort(nums.begin(), nums.end());
        int sum3 = 0, min = nums[0]+nums[1]+nums[2];
        if(size==3) return min;
        for(int a=0; a<size-2;){
            for(int b=a+1, c=size-1; b<c;){
                sum3 = nums[a] + nums[b] +nums[c];
                if(abs(sum3-target)<abs(min-target))
                    min = sum3;
                if(sum3<target){
                    do b++; while(b<c-1&&nums[b]==nums[b+1]);
                }else if(sum3>target){
                    do c--; while(c>b+1&&nums[c]==nums[c-1]);
                }else return target;
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

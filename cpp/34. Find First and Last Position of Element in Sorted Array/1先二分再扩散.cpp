#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans({-1,-1});
        int size = nums.size();
        if(size==0) return ans;
        ans[0]=ans[1]=biSearch(nums, target);
        while(ans[0]>0){
            if(nums[ans[0]-1]!=target)
                break;
            ans[0]--;
        }
        while(ans[1]<size-1){
            if(nums[ans[1]+1]!=target)
                break;
            ans[1]++;
        }
        return ans;
    }
    int biSearch(vector<int> nums, int target){
        if(nums.size()==0) return -1;
        int first = 0, second = nums.size()-1, mid = (first+second)/2;
        while(first<second){
            if(nums[mid]<target){
                first = mid+1;
            }else if(nums[mid]>target){
                second = mid;
            }else break;
            mid = (first+second)/2;
        }
        return nums[mid]==target?mid:-1;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.searchRange(vector<int>({5,7,7,8,8,10}), 8);
    return 0;
}

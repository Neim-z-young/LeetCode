#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans({-1,-1});
        int size = nums.size();
        int left = specialBiSearch(nums, target, true);
        if(left==size||nums[left]!=target){
            return ans;
        }
        ans[0] = left;
        ans[1] = specialBiSearch(nums, target, false) -1;
        return ans;
    }
private:
    //找出的左下标不一定是有效的，右下标也不一定有效
    int specialBiSearch(vector<int> nums, int target, bool left){
        int first = 0, second = nums.size();
        while(first<second){
            int mid = first+(second-first)/2;
            if(nums[mid]>target||(left&&nums[mid]==target)){
                second = mid;
            }else{
                first = mid+1;
            }
        }
        return first;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.searchRange(vector<int>({5,7,7,8,8,10}), 8);
    return 0;
}

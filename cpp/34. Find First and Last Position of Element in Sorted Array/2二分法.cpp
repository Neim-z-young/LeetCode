#include<iostream>
#include<vector>
using namespace std;
//使用int mid = lo + (hi - lo) / 2能更好的防止整数溢出
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans({-1,-1});
        int size = nums.size();
        if(size==0) return ans;
        int first, second;
        first=second=biSearch(nums, 0, size-1, target);
        while(first!=-1){
            ans[0] = first;
            first = biSearch(nums, 0, first-1, target);
        }
        while(second!=-1){
            ans[1] = second;
            second = biSearch(nums, second+1, size-1, target);
        }
        return ans;
    }
private:
    int biSearch(vector<int> nums, int first, int second, int target){
        if(first>second) return -1;
        int mid = (first+second)/2;
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

#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int first = 0, second=nums.size(), mid = first+(second-first)/2;
        while(first<second){
            if(nums[mid]>=target) second = mid;
            else first = mid + 1;
            mid = first+(second-first)/2;
        }
        return first;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}

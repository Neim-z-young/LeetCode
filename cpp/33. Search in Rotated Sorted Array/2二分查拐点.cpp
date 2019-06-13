#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int size = nums.size();
        if(size==0) return -1;
        int first = 0, second = size-1;
        int mid = (first+second)/2;
        //找最值下标
        while(first<second&&nums[mid]<nums[mid+1]){
            if(nums[mid]>=nums[first]){
                //mid在max前
                first = mid+1;
            }else{
                //mid在max后
                second = mid;
            }
            mid = (first+second)/2;
            //找到最值
            if(first==second||mid==size-1) break;
        }
        //在有序位置中查找
        if(target<=nums[mid]&&target>=nums[0]) return bSearch(nums, 0, mid, target);
        else return bSearch(nums, mid+1, size-1, target);
    }
private:
    int bSearch(vector<int>& nums, int first, int second, int tar){
        //判断是否有意义
        if(first>second) return -1;
        int mid = (first+second)/2;
        if(nums[mid]==tar) return mid;
        if(first==second) return -1;
        if(nums[mid]>tar) second = mid;
        else first = mid+1;
        return bSearch(nums, first, second, tar);
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.search(vector<int>({3,1}), 3)<<endl;
    cout<<ans.search(vector<int>({1,3}), 3)<<endl;
    cout<<ans.search(vector<int>({3,5,6,7,0,1}), 3)<<endl;
    cout<<ans.search(vector<int>({7,8,9,10,1,2,3}), 1)<<endl;
    cout<<ans.search(vector<int>({}), 3)<<endl;
    cout<<ans.search(vector<int>({1,2}), 3)<<endl;
    cout<<ans.search(vector<int>({4,5,6,7,0,1,2}), 0)<<endl;
    return 0;
}

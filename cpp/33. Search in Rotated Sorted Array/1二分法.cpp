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
        while(nums[mid]!=target&&first<second){
            if(nums[mid]>=nums[first]){
                //mid在max前
                if(nums[mid]>target&&nums[second]<target){
                    //mid前一段
                    second = mid;
                }else if(nums[mid]<target||(nums[first]>target&&target<=nums[second])){
                    //mid后一段
                    first = mid+1;
                }else{
                    //升序,二分查找
                    second = mid;
                }
            }else{
                //mid在max后
                if(nums[mid]<target&&target<nums[first]){
                    //mid后一段
                    first = mid+1;
                }else if(nums[mid]>target||target>=nums[first]){
                    //mid前一段
                    second = mid;
                }
            }
            mid = (first+second)/2;
            if(first==second) break;
        }
        if(nums[mid]==target) return mid;
        else return -1;
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

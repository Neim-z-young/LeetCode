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
        //与或非化简 ^表示合取，v表示析取
        //(A^(Bv(C^D)))v(~A^B^C)
        //==>(A^(Bv(C^D)))v(B^C)
        while(first<second){
            if((nums[mid]>=nums[first]&&(nums[mid]<target||(nums[first]>target&&target<=nums[second])))||(nums[mid]<target&&target<=nums[second])){
                first = mid+1;
            }else second = mid;
            mid = (first+second)/2;
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

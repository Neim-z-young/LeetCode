#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int size = nums.size();
        if(size<2) return;
        int min = nums[size-1];
        int minInx = size-1;
        //从尾部开始遍历
        //找到某个值比其后面的数小则停下
        for(int i=size-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                for(int j=size-1; j>i; j--){
                    if(nums[j]>nums[i]){
                        minInx = j;
                        min = nums[j];
                        break;
                    }
                }
                nums[minInx] = nums[i];
                nums[i] = min;
                reverse(nums.begin()+i+1, nums.end());
                return;
            }
            if(i==0){
                reverse(nums.begin(), nums.end());
            }
        }
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

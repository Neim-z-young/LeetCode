#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len = nums.size();
        if(len<2) return len;
        int noRepeat=0, cur=0;    
        while(cur<len){
            nums[noRepeat] = nums[cur];
            noRepeat++;
            do cur++; while(cur<len&&nums[cur]==nums[cur-1]);
        }
        return noRepeat;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}

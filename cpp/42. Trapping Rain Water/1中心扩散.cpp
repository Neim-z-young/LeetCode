#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int trap(vector<int>& height) {
        vector<int> ans = height;
        int size = ans.size();
        if(size<3) return 0;
        int left=0, right=0;
        int i=0;
        while(i<size){
            left=right=i;
            while(left!=0&&right!=size-1&&ans[left-1]>=ans[i]&&ans[right+1]>=ans[i]){
                int high = ans[left-1]>ans[right+1]?ans[right+1]:ans[left-1];
                for(int j=left; j<=right; j++){
                    ans[j]=high;
                }
                //找左边界
                while(left>0&&ans[left-1]==ans[left]){
                    left--;
                }
                //找右边界
                while(right<size-1&&ans[right+1]==ans[right]){
                    right++;
                }
            }
            i=right+1;
        }
        int count=0;
        for(int i=0; i<size; i++){
            count+=(ans[i]-height[i]);
        }
        return count;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.trap(vector<int>{0,1,0,2,1,0,1,3,2,1,2,1});
    return 0;
}


#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

//前后夹击，找短板，哪边矮哪边动，掐死较高的一端显然是错误的，前后都能活动才是OK的
class Solution {
public:
    int maxArea(vector<int>& height) {
        int i=0, j=height.size()-1;
        int area = 0;
        while(i<j){
            int lower = min(height[i], height[j]);
            int temp = (j-i)*lower;
            if(temp>area) area=temp;
            if(lower==height[i]) i++;
            else j--;
        }
        return area;
    }
};

int main(int argc, char const *argv[]){
    vector<int> h = {2,3,4,5,18,17,6};
    Solution ans;
    cout<<ans.maxArea(h);
    return 0;
}
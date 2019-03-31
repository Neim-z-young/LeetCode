#include<iostream>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        for(int i=x;i!=0;i=i/10){
            int remain = i%10;
            if(ans>INT32_MAX/10 || (ans == INT32_MAX / 10 && remain > 7)){return 0;}
            if(ans<INT32_MIN/10 || (ans == INT32_MIN / 10 && remain < -8)){return 0;}
            ans= ans*10 + remain;
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    int a=1534236469;
    Solution ans;
    cout<<ans.reverse(a);
    return 0;
}

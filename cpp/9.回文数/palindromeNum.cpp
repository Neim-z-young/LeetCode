#include<iostream>
using namespace std;
class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int ans = 0;
        for(int i=x;i!=0;i=i/10){
            int remain = i%10;
            if(ans>INT32_MAX/10 || (ans == INT_MAX / 10 && remain > 7)){return false;}
            if(ans<INT32_MIN/10 || (ans == INT_MIN / 10 && remain < -8)){return false;}
            ans= ans*10 + remain;
        }
        return ans==x;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    cout<<ans.isPalindrome(121);
    return 0;
}

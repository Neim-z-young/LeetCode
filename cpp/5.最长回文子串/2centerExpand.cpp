
#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.length();
        int max_len=0;
        int max_i=0;
        bool *P = new bool[len*len];
        for(int i=0;i<len;){
            if(len-i<=max_len/2) break;
            int right=i,left=i;
            while(right<len-1&&s[right+1]==s[right]) ++right;
            i=right+1;
            while(right<len-1&&left>0&&s[left-1]==s[right+1]) {--left; ++right;}
            if(right-left+1>max_len){
                max_len = right-left+1;
                max_i = left;
            }
        }
        return s.substr(max_i, max_len);
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    cout<<ans.longestPalindrome("abcda");
    return 0;
}
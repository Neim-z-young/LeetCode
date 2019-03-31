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
        for(int i=0;i<len*len;i++){
            P[i]=false;
        }
        for(int i=len-1; i>=0;i--){
            for(int j=len-1; j>=i; j--){
                if(j-i<=1){
                    if(s[i]==s[j]){
                        P[i*len+j]=true;
                        if(max_len<j-i+1){
                            max_len = j-i+1;
                            max_i = i;
                        }
                    }
                }
                else{
                    if(s[i]==s[j]&&P[(i+1)*len+j-1]){
                        P[i*len+j]=true;
                        if(max_len<j-i+1){
                            max_len = j-i+1;
                            max_i = i;
                        }
                    }
                }
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

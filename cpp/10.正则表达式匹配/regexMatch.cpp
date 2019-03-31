#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    bool isMatch(string s, string p) {
        int lens = s.length();
        int lenp = p.length();
        if(lenp==0 && lens==0) return true;
        if(lenp==0 && lens!=0) return false;
        if(lenp!=0 && p[0]=='*') return false;
        int j = 0;
        for(int i = 0; i < lenp; i++){
            switch (p[i])
            {
                case '.':
                    if(j<lens){
                        j++;
                    }
                    break;
                case '*':
                    char temp;
                    if(p[i-1]=='.') temp = s[j-1];
                    else if(p[i-1]>='a'&&p[i-1]<='z') temp = p[i-1];
                    else return false;
                    while(j<lens && temp==s[j]){
                        j++;
                    }
                    break;
                default:
                    if(j<lens && s[j]==p[i]) j++;
                    break;
            }
        }
        return j == lens;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    cout<<ans.isMatch("", "a*");
    return 0;
}

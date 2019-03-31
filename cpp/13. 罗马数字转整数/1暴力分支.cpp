#include<string>
#include<iostream>
using namespace std;
class Solution {
public:
    int romanToInt(string s) {
        int len = s.length();
        int ans = 0;
        for(int i=0; i<len; i++){
            switch(s[i]){
                case 'I':
                    if(i<len-1&&(s[i+1]=='X'||s[i+1]=='V'))
                        ans-=1;
                    else ans+=1;
                break;
                case 'V':
                    ans+=5;
                break;
                case 'X':
                    if(i<len-1&&(s[i+1]=='L'||s[i+1]=='C'))
                        ans-=10;
                    else ans+=10;
                break;
                case 'L':
                    ans+=50;
                break;
                case 'C':
                    if(i<len-1&&(s[i+1]=='D'||s[i+1]=='M'))
                        ans-=100;
                    else ans+=100;
                break;
                case 'D':
                    ans+=500;
                break;
                case 'M':
                    ans+=1000;
            }
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.romanToInt("MCMXCIV");
    return 0;
}

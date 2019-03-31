#include<string>
#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;
        int len = s.length();
        int circle = 2*numRows-2;
        string ret;
        for(int i=0;i<numRows;i++){
            for(int j=0;i+j<len;j+=circle){
                ret+=s[i+j];
                if(i!=0&&i!=numRows-1&&(j+circle-i)<len){
                    ret+=s[j+circle-i];
                }
            }
        }
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.convert("A", 4);
    return 0;
}

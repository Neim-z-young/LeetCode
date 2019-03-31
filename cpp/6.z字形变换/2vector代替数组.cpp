#include<string>
#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;
        int len = s.length();
        vector<string> rows(min(numRows, len));
        int index = 0;
        int i = 0;
        bool goingDown = false;
        while(index<len){
            rows[i]+=s[index];
            index++;
            if(i==0||i==numRows-1) goingDown=!goingDown;
            i+=goingDown? 1 : -1;
        }
        string ret;
        for(string row:rows)ret+=row;
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.convert("ABCD", 10);
    return 0;
}

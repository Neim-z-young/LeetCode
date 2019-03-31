#include<iostream>
#include<string>
#include<vector>
using namespace std;
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int size = strs.size();
        if(size==0) return "";
        int minLen = strs[0].length();
        string common = "";
        for(int i=1; i<size; i++){
            if(minLen>strs[i].length())
                minLen = strs[i].length();
        }
        for(int i=0; i<minLen; i++){
            char temp = strs[0][i];
            for(int j=1; j<size; j++){
                if(temp!=strs[j][i])
                    return common;
            }
            common+=temp;
        }
        return common;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    vector<string> strs = {"flower","flow","flight"};
    cout<<ans.longestCommonPrefix(strs);
    return 0;
}

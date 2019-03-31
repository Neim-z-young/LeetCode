#include<iostream>
#include<string>
#include<vector>
using namespace std;
//容器或string类的size()或length方法返回的是size_t类型的值，不是int型
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle=="") return 0;
        int len = haystack.size();
        int lenP = needle.size();
        int i=0, j=0;
        vector<int> theNext = getNext(needle);
        while((i<len)&&(j<lenP)){
            if(j==-1||needle[j]==haystack[i]){
                i++;
                j++;
            }else{
                j = theNext[j];
            }
        }
        if(j>=lenP) return i-j;
        else return -1;
    }
private:
    vector<int> getNext(string pattern){
        int len = pattern.length();
        vector<int> theNext(len);
        theNext[0]=-1;
        int index = -1;
        int j=0;
        while(j<len-1){
            if(index==-1||pattern[index]==pattern[j]){
                index++;
                j++;
                theNext[j] = index;
            }else{
                index = theNext[index];
            }
        }
        return theNext;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    cout<<ans.strStr(string("hello"), string("ll"));
    return 0;
}

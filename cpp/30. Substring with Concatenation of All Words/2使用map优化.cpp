#include<string>
#include<vector>
#include<unordered_map>
using namespace std;
//用了map后，勉勉强强过了
class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int len = words.size();
        vector<int> ans(0);
        if(len==0) return ans;
        int slen = s.size();
        int wlen = words[0].size();
        unordered_map<string, int> wordsMap;
        for(int i=0; i<len; i++) wordsMap[words[i]]++;
        //i后面剩余的长度要小于单词总长度
        for(int i=0; i<slen-wlen*len+1; i++){
            //复制容器太耗时了
            unordered_map dict = wordsMap;
            int j=i;
            while(j<slen){
                dict[s.substr(j, wlen)]--;
                if(dict[s.substr(j, wlen)]<0) break;
                j+=wlen;
            }
            if(j-i==wlen*len) ans.push_back(i);
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

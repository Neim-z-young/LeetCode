#include<string>
#include<vector>
#include<unordered_map>
using namespace std;
//使用滑动窗口，使得i只需遍历一个word长度就行，但是总的遍历次数和map的是一样的。
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
        for(int i=0; i<wlen; i++){
            //单词计数，窗口的左边界
            int count=0, left=i;
            unordered_map<string, int> dict;
            int j=left;
            //进行窗口滑动
            while(j<slen){
                string subS = s.substr(j, wlen);
                if(wordsMap.count(subS)){
                    int cnt = wordsMap[subS];
                    dict[subS]++;
                    count++;
                    //去除重复多余的单词
                    while(dict[subS]>cnt){
                        dict[s.substr(left, wlen)]--;
                        count--;
                        left+=wlen;
                    }
                    if(count==len){
                        ans.push_back(left);
                        dict[s.substr(left, wlen)]--;
                        count--;
                        left+=wlen;
                    }
                }else {
                    dict.clear();
                    count=0;
                    left=j+wlen;
                }
                j+=wlen;
            }
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    ans.findSubstring("wordgoodgoodgoodbestword", vector<string>({"word","good","best","word"}));
    return 0;
}

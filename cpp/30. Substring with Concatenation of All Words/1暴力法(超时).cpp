#include<string>
#include<vector>
using namespace std;
//暴力法，直接超时
class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int len = words.size();
        vector<int> ans(0);
        if(len==0) return ans;
        int slen = s.size();
        int wlen = words[0].size();
        for(int i=0; i<slen; i++){
            vector<string> temp = words;
            int j=i;
            while(j<slen){
                int index = findWord(s, j, wlen, temp);
                if(index==-1){
                    break;
                }
                temp[index]=" ";
                j+=wlen;
            }
            if(j-i==wlen*len) ans.push_back(i);
        }
        return ans;
    }
private:
    int findWord(string word, int index, int wlen, vector<string> words){
        int len = words.size();
        for(int i = 0; i< len; i++){
            int j=0;
            while(j<wlen){
                if(word[index+j]!=words[i][j])
                    break;
                j++;
            }
            if(j==wlen){
                return i;
            }
        }
        return -1;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

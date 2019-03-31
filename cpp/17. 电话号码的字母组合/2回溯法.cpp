#include<string>
#include<vector>
using namespace std;
//基于回溯方法
const char NUM_ARRAY[10][5]={
    "",
    "",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz"
    };
int LEN_ARRAY[]={0,0,3,3,3,3,3,4,3,4};
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        int len = digits.length();
        if(len==0) return vector<string>();
        return backTraking("", digits, 0);
    }
private:
    vector<string> backTraking(string combination, string digits, int nextdigit){
        if(!digits[nextdigit]) return vector<string>({combination});
        int len = LEN_ARRAY[digits[nextdigit]-'0'];
        vector<string> res;
        for(int i=0; i<len; i++){
            vector<string> temp = backTraking(combination + NUM_ARRAY[digits[nextdigit]-'0'][i], digits, nextdigit+1);
            res.insert(res.end(), temp.begin(), temp.end());
        }
        return res;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.letterCombinations("232");
    return 0;
}

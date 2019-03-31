#include<string>
#include<vector>
using namespace std;
//基于数字的基数转换
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
        int Slen = 1;
        int* numBase = new int[len];
        for(int i=0; i<len; i++){
            numBase[i] = LEN_ARRAY[digits[i]-'0'];
            Slen*=numBase[i];
        }
        for(int i=0; i<Slen; i++){
            vector<int> ansIndex = scaleConvert(i, Slen, numBase, len);
            string ansS;
            for(int j=0; j<len; j++){
                ansS+=NUM_ARRAY[digits[j]-'0'][ansIndex[j]];
            }
            ans.push_back(ansS);
        }
        return ans;
    }
private:
 //convert the arg num to a series of char index based on numBase
    vector<int> scaleConvert(int num, int timesNum, int* numBase, int len){
        vector<int> res;
        for(int i=0; i<len; i++){
            timesNum = timesNum/numBase[i];
            res.push_back(num/timesNum);
            num%=timesNum;
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

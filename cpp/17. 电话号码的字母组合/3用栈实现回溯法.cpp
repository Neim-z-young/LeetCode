#include<string>
#include<vector>
using namespace std;
//回溯方法的栈实现
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
        vector<string> strStack;
        strStack.push_back(string(""));
        int size = strStack.size();
        int layer = 0;
        while(size>0){
            string str = strStack[size-1];
            strStack.pop_back();
            size--;
            for(int i=0; i<LEN_ARRAY[digits[layer]-'0']; i++){
                strStack.push_back(str+NUM_ARRAY[digits[layer]-'0'][i]);
                size++;
            }
            layer++;
            if(layer==len){
                for(int j=0; j<LEN_ARRAY[digits[layer-1]-'0']; j++){
                    string tempS = strStack[size-1];
                    strStack.pop_back();
                    size--;
                    ans.push_back(tempS);
                }
                //两层交界处，需要跳跃层次，避免访问越界，使用length方法
                while(size>0&&strStack[size-1].length()<layer) layer--;
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.letterCombinations("232");
    return 0;
}

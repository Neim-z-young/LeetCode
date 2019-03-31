#include<iostream>
#include<string>
#include<vector>
using namespace std;
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        return recursionGenerate(n);
    }
private:
    vector<string> recursionGenerate(int n){
        int m = 2*n;
        if(m<=0) return vector<string>({""});
        if(m==2){
            return vector<string>({"()"});
        }
        vector<string> ans;
        for(int i=1; i<=n; i++){
            string tempS="";
            vector<string> temp1, temp2;
            temp1 = recursionGenerate(i-1);
            temp2 = recursionGenerate(n-i);
            for(int j=0; j<temp1.size(); j++){
                for(int k=0; k<temp2.size(); k++){
                    ans.push_back("("+temp1[j]+")"+temp2[k]);
                }
            }
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.generateParenthesis(2);
    return 0;
}

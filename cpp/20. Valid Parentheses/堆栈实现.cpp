#include<iostream>
#include<string>
#include<stack>
using namespace std;
class Solution {
public:
    bool isValid(string s) {
        stack<char> parethesis;
        int len =s.length();
        for(int i=0; i<len; i++){
            switch(s[i]){
                case '(':
                case '[':
                case '{':
                    parethesis.push(s[i]);
                    break;
                case ')':
                    if(parethesis.empty()||parethesis.top()!='(')
                        return false;
                    parethesis.pop();
                    break;
                case ']':
                    if(parethesis.empty()||parethesis.top()!='[')
                        return false;
                    parethesis.pop();
                    break;
                case '}':
                    if(parethesis.empty()||parethesis.top()!='{')
                        return false;
                    parethesis.pop();
                    break;
                default:
                return false;
            }
        }
        if(parethesis.empty()){
            return true;
        }
        return false;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    if(ans.isValid("[]{}))")) 
        cout<<"yes";
    else
        cout<<"no";
    
    return 0;
}

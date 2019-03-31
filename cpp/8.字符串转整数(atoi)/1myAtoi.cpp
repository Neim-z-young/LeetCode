#include<iostream>
#include<string>
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        int len = str.length();
        int ans=0;
        int flag=1;
        bool numFlag=false;
        for(int i=0;i<len;i++){
            if((str[i]==' '&&numFlag)||(str[i]!=' '&&str[i]!='-'&&str[i]!='+'&&(str[i]<'0'||str[i]>'9'))){
                break;
            }
            else if(str[i]=='-'){
                if(!numFlag&&i+1<len&&str[i+1]>='0'&&str[i+1]<='9') {flag=-1;}
                else {break;}
            }
            else if(str[i]=='+'){
                if(!numFlag&&i+1<len&&str[i+1]>='0'&&str[i+1]<='9') {flag=1;}
                else {break;}
            }
            else if(str[i]>='0'&&str[i]<='9'){
                if(ans>INT32_MAX/10||(ans==INT32_MAX/10&&str[i]>'7')){return INT32_MAX;}
                if(ans<INT32_MIN/10 || (ans == INT32_MIN/10 && str[i]>'8')){return INT32_MIN;}
                numFlag = true;
                ans = ans*10+(str[i]-48)*flag;
            }
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.myAtoi("  -10-2 21 12");
    return 0;
}

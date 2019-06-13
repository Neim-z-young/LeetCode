#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    string countAndSay(int n) {
        if(n<1) return "";
        string ans = "1";
        for(int i=0; i<n-1 ;i++)
            ans = generate(ans);
        return ans;
    }
private:
    string generate(string s){
        int size = s.size();
        string ans;
        for(int i=0; i<size; ){
            int count=0;
            do{
                count++;
                i++;
            }while(i<size&&s[i-1]==s[i]);
            char tmp = count+'0';
            ans = ans+tmp+s[i-1];
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

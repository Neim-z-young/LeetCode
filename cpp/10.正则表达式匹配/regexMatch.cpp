#include<iostream>
#include<string>
using namespace std;
class Solution {
public:

//递归超时了
    bool isMatch(string s, string p) {
        return isMatch(s, 0, p, 0);
    }
    bool isMatch(string s, int is, string p, int ip){
        if(is==s.length() && ip==p.length()) return true;
        if(ip==p.length()) return false;

        if(ip<p.length()-1 && p[ip+1]=='*'){
            if(is<s.length()&& (p[ip]=='.' || p[ip]==s[is])){
                return isMatch(s, is, p, ip+2) || isMatch(s, is+1, p, ip);
            }else
            {
                return isMatch(s, is, p, ip+2);
            }
        }else if(is<s.length() && ip<p.length()){
            if(p[ip]=='.' || p[ip]==s[is])
                return isMatch(s, is+1, p, ip+1);
        }
        return false;
    }

    bool isMatch1(string s, string p) {
        return isMatch1(s, 0, p, 0);
    }
    bool isMatch1(string s, int is, string p, int ip){
        if(is==s.length() && ip==p.length()) return true;
        if(ip==p.length()) return false;
        
        if(is==s.length()){
            if(ip+1<p.length() && p[ip+1]=='*')
                //类似情况 s="" p="a*b*"
                return isMatch1(s, is, p, ip+2);
            else if(ip>0 && p[ip]=='*')
                //类似情况 s="" p="a*"
                return isMatch1(s, is, p, ip+1);
            else{
                return false;
            }
        }

        if(is>=0 && is<s.length() && (p[ip]=='.' || p[ip]==s[is])){
            return isMatch1(s, is+1, p, ip+1);
        }else if(ip>0 && p[ip]=='*'){
            bool ans = false;
            //匹配0次   匹配1或多次
            return isMatch1(s, is-1, p, ip+1) || isMatch1(s, is, p, ip-1);
        }
        return false;
    }


    //DP 方法
    // bool isMatch(string s, string p) {
    //     bool dp[p.size()+1][s.size()+1] = {false};
    //     dp[0][0] = true;
    //     for (int j = 1; j < s.size() + 1; j++)
    //         dp[0][j] = s.size() == 0;
    //     for (int i = 1; i < p.size() + 1; i++) {
    //         bool ast = p[i-1] == '*';
    //         dp[i][0] = ast && dp[i-2][0];
    //         for (int j = 1; j < s.size() + 1; j++)
    //             dp[i][j] = ast && dp[i-2][j] || (p[i-1-ast] == '.' || p[i-1-ast] == s[j-1]) && dp[i-1+ast][j-1];
    //     }
    //     return dp[p.size()][s.size()];
    // }

};
int main(int argc, char const *argv[])
{
    /* code */
    Solution ans;
    cout<<ans.isMatch1("ab", ".*c");
    cout<<ans.isMatch1("aa", "a*");
    cout<<ans.isMatch1("a", "a*b*");
    cout<<ans.isMatch1("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
    return 0;
}

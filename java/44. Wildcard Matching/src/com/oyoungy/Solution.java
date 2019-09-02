package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    //通配符匹配 ？ *
    public boolean isMatch(String s, String p) {
        return dpSolution(s, p);
    }

    boolean[][] dp;

    //dp method
    //dp[i][j] is the match case between s[1..i] and p[1..j]
    private boolean dpSolution(String s, String p){
        dp = new boolean[s.length()+1][p.length()+1];

        //initial sub problems
        dp[0][0] = true;
        //dp[0][j];
        for(int j=1; j<p.length()+1; j++){
            dp[0][j] = p.charAt(j-1)=='*' && dp[0][j-1];  //for the case: s is ""
        }
        //dp[i][0];
        for(int i=1; i<s.length()+1; i++){
            dp[i][0] = false;        //for the case: p is ""
        }
        //using dp formula(bottom up)
        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<p.length()+1; j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(p.charAt(j-1)=='?' || p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    //recursive method
    //"aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
    //"a*******b"
    //OUT OF TIME !!!!!!
    private boolean isMatch(String s, int is, String p, int ip){
        if(is==s.length() && ip==p.length()) return true;
        else if(ip==p.length() && is<s.length()) return false;
        else if(is==s.length()) {
            if(p.charAt(ip)=='*')
                return isMatch(s, is, p, ip+1);
            else
                return false;
        }

        if(p.charAt(ip)=='?' || p.charAt(ip)==s.charAt(is)){
            return isMatch(s, is+1, p, ip+1);
        }else if(p.charAt(ip)=='*'){
            // not match  || match once
            return isMatch(s, is, p, ip+1) || isMatch(s, is+1, p, ip);
        }
        return false;
    }
}
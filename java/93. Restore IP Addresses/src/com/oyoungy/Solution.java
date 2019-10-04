package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        List<String> t = ans.restoreIpAddresses("010010");
        System.out.println();
    }
    public List<String> restoreIpAddresses(String s) {
        return restoreIp(s.toCharArray(), s.length(), 4);
    }
    private List<String> restoreIp(char[] s, int index, int pos){
        List<String> ans = new ArrayList<>();
        //recursive
        if(pos==1){
            if(isValidIp(s, 0, index)){
                StringBuilder str = new StringBuilder();
                for(int i=0; i<index; i++){
                    str.append(s[i]);
                }
                str.append('.');
                ans.add(str.toString());
            }
            return ans;
        }

        for(int i=1; i<4; i++){
            if(isValidIp(s, index-i, index)){
                StringBuilder str  = new StringBuilder();
                for(int j=index-i; j<index; j++){
                    str.append(s[j]);
                }
                if(pos!=4) str.append('.');
                List<String> temp = restoreIp(s, index-i, pos-1);
                for(String s1:temp){
                    s1 = s1.concat(str.toString());
                    ans.add(s1);
                }
            }
        }
        return ans;
    }
    //one number
    //two number
    //three number then value < 256
    //s[start]==0 then end should be start+1
    private boolean isValidIp(char[] s, int start, int end){
        if(end-start>3 || end-start<=0 || start<0 || end>s.length || (s[start]=='0' && end>start+1)){
            return false;
        }
        if(end-start<3) return true;
        int value = 0;
        while (start<end){
            value = value*10+s[start]-'0';
            start++;
        }
        return value<256;
    }
}
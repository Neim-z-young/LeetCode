package com.oyoungy;


public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int numDecodings(String s) {
        return s==null ? 0 : numDecoding(s.toCharArray(), 0);
    }
    private int numDecoding(char[] s, int index){
        if(index==s.length) return 1;
        if(s[index]<'1' || s[index]>'9') return 0;
        int count = 0;
        //解析一个字符
        count += numDecoding(s, index+1);
        //解析两个字符
        if(index+1<s.length && (s[index]=='1' || (s[index]=='2'&&s[index+1]<='6'))){
            count += numDecoding(s, index+2);
        }
        return count;
    }
}
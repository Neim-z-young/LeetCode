package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int lengthOfLastWord(String s) {
        int len = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==' ' && len!=0){
                break;
            }else if(s.charAt(i)!=' '){
                len++;
            }
        }
        return len;
    }
}
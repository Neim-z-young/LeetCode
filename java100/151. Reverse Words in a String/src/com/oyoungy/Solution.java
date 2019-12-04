package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.reverseWords("  hello world!  "));
    }
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] rawWord = s.trim().split("\\s+");
        for(int i=rawWord.length-1; i>=0; i--){
            ans.append(rawWord[i]);
            if(i!=0){
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}
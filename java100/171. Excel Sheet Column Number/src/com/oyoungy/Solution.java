package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.titleToNumber("AA"));
        System.out.println(ans.titleToNumber("FZ"));
        System.out.println(ans.titleToNumber("GA"));
        System.out.println(ans.titleToNumber("ZY"));
    }
    public int titleToNumber(String s) {
        int radix = 1, ans = 0;
        for (int i=s.length()-1; i>=0; i--){
            ans+=radix*(s.charAt(i)-'A'+1);
            radix*=26;
        }
        return ans;
    }
}
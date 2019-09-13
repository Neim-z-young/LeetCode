package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.addBinary("11", "1"));
    }
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int aInx = a.length()-1, bInx = b.length()-1;
        int carry = 0;
        while (aInx>=0 && bInx>=0){
            int temp = a.charAt(aInx) - '0' + b.charAt(bInx) - '0' + carry;
            carry = temp>>1;
            str.append((char)('0'+(temp&1)));
            aInx--;
            bInx--;
        }
        String t;
        int tInx;
        if(aInx<0){
            t = b;
            tInx = bInx;
        }else {
            t = a;
            tInx = aInx;
        }
        while (tInx>=0){
            int temp = t.charAt(tInx)-'0' + carry;
            carry = temp>>1;
            str.append((char)('0'+(temp&1)));
            tInx--;
        }
        if(carry==1){
            str.append('1');
        }
        return str.reverse().toString();
    }
}
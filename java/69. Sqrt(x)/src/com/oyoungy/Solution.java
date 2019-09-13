package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int mySqrt(int x) {
        for (int i=0; i<=x; i++){
            long square = ((long)i)*i;
            if(square==x) return i;
            else if(square>x) return i-1;
        }
        return 0;
    }
}
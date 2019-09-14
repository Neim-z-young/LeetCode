package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    //fibonacci
    public int climbStairs(int n) {
        if(n==0) return 0;
        int d1 = 0, d2 = 1;
        while (n-->0){
            int temp = d2;
            d2 = d1+d2;
            d1 = temp;
        }
        return d2;
    }
}
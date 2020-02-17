package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            if((n&1)!=0)
                count++;
            n>>>=1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);  //将最右边的一个1清0
        }
        return count;
    }
}
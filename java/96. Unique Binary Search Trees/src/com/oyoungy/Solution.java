package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.numTrees(3));
    }
    //dp
    public int numTrees(int n) {
        if(n==0) return 0;
        int nums[] = new int[n+1];
        nums[0] = 1;
        for(int i=1; i<n+1; i++){
            int count = 0;
            for(int j=1; j<=i; j++){
                count+=(nums[j-1] * nums[i-j]);
            }
            nums[i] = count;
        }
        return nums[n];
    }
}
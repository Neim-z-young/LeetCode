package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int singleNumber(int[] nums) {
        int t=0;
        for(int i=0; i<nums.length; i++){
            t^=nums[i];
        }
        return t;
    }
}
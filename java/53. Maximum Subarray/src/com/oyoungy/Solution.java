package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxSum = 0, max = nums[0];
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max) max = nums[i];
            if(temp+nums[i]<0) {
                temp=0;
                continue;
            }
            temp+=nums[i];
            if(temp>maxSum){
                maxSum = temp;
            }
        }
        return max<0 ? max : maxSum;
    }
}
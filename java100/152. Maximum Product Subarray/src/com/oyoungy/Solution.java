package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }


    public int maxProduct(int[] nums) {
        return getMaxProduct(nums);
    }

    //Great algorithm
    private int getMaxProduct(int[] nums){
        int[] low = new int[nums.length];
        int[] high = new int[nums.length];

        for(int i = nums.length -1 ; i>= 0; i--){
            if(i == nums.length - 1){
                low[i] = nums[i];
                high[i] = nums[i];
            }else{
                int lowMin = Math.min(nums[i], Math.min(nums[i] * low[i+1], nums[i] * high[i+1]));
                int highMax = Math.max(nums[i], Math.max(nums[i] * low[i+1], nums[i] * high[i+1]));
                low[i] = lowMin;
                high[i] = highMax;
            }
        }

        int max = Integer.MIN_VALUE;

        for(Integer n : high){
            max = Math.max(max, n);
        }

        return max;
    }
}
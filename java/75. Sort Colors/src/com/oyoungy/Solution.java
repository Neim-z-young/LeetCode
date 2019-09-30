package com.oyoungy;

import java.util.logging.Level;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
        int low = 0, high = nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                swapInx(nums, i, low);
                low++;
            }else if(nums[i]==2 && i<high){
                swapInx(nums, i, high);
                high--;
                i--;  //key
            }
        }
    }
    public void swapInx(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
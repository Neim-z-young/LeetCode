package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) return false;
        if(nums.length==1) return true;
        int reachMax = 0;
        for(int i=0; i<nums.length-1; i++){
            if(i<=reachMax){
                if(nums[i]+i>reachMax){
                    reachMax = nums[i]+i;
                    if(reachMax>=nums.length-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
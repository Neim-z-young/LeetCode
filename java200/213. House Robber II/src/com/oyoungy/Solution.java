package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        //将环转化为非环
        int len = nums.length, max_1, max_2;

        //不抢第一家
        int[] robbed = new int[len+1], nonRobbed = new int[len+1];
        for(int i=1; i<len; i++){
            robbed[i+1] = nonRobbed[i]+nums[i];
            nonRobbed[i+1] = Math.max(robbed[i], nonRobbed[i]);
        }
        max_1 = Math.max(robbed[len], nonRobbed[len]);

        //不抢最后一家
        for(int i=0; i<len-1; i++){
            robbed[i+1] = nonRobbed[i]+nums[i];
            nonRobbed[i+1] = Math.max(robbed[i], nonRobbed[i]);
        }
        max_2 = Math.max(robbed[len-1], nonRobbed[len-1]);

        return Math.max(max_1, max_2);
    }
}
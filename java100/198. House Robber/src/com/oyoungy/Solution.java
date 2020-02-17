package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * 使用两数组动态规划
     * robbed[i]表示抢劫第i-1家
     * nonRod[i]表示不抢劫第i-1家
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        int[] robbed =  new int[n], nonRob = new int[n];
        robbed[0] = nums[0];
        nonRob[0] = 0;
        for (int i=1; i<n; i++){
            robbed[i] = nonRob[i-1]+nums[i];
            nonRob[i] = Math.max(nonRob[i-1], robbed[i-1]);
        }
        return Math.max(nonRob[n-1], robbed[n-1]);
    }
}
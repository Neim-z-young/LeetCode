package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    //数组由正整数组成
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int start = 0, length = nums.length;
        int accumulate = nums[start], minLength = length+1, tmpL = 1;
        for (int i = 1; i < length; i++) {
            if (accumulate < s) {
                accumulate += nums[i];
                tmpL++;
            }
            while (accumulate >= s) {
                if (minLength > tmpL) {
                    minLength = tmpL;
                }
                accumulate -= nums[start++];
                tmpL--;
                if (start >= length) {
                    break;
                }
            }
        }
        return minLength == length+1?0:minLength;
    }
}
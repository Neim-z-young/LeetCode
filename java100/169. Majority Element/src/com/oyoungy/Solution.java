package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    /**
     *  Boyer-Moore Voting Algorithm
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int flag = 1, pivot = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pivot)
                flag++;
            else
                flag--;
            if(flag==0){
                pivot = nums[i];
                flag = 1;
            }
        }
        return pivot;
    }
}
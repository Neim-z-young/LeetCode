package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = nums[0], count = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur) {
                cur = nums[i];
                count = 1;
                if (index != i) {
                    nums[index] = nums[i];
                }
                index++;
            } else if (cur == nums[i] && count++ < 2) {
                if (index != i) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index;
    }
}
package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.findPeakElement(new int[]{1,4,2,3,5,6,7,8,9,10}));
    }

    /**
     * linear solution
     *
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                return i;
        return nums.length - 1;
    }

    /**
     * binary search
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]>nums[mid+1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
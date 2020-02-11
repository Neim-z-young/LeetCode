package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[low] > nums[high])
                if (nums[mid] >= nums[low])
                    low = mid + 1;
                else
                    high = mid;
            else if (nums[low] < nums[high])
                return nums[low];
            else if (nums[mid] > nums[low]) {
                low = mid + 1;
            } else if (nums[mid] < nums[low]) {
                high = mid;
            } else {
                low++;
                high--;
            }
        }
        return nums[low];
    }
}
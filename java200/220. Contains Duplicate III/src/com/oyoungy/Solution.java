package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long tmp = t;
        for (long i=0; i<nums.length; i++){
            for (long j=i+1; j<=(i+k) && j<nums.length; j++){
                if(Math.abs((long)nums[(int)i]-(long)nums[(int)j])<=tmp)
                    return true;
            }
        }
        return false;
    }
}
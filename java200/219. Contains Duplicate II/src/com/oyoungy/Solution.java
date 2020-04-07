package com.oyoungy;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer integer = map.get(nums[i]);
            if(integer!=null){
                if(i-integer<=k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
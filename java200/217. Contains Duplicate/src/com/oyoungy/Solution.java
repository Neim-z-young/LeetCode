package com.oyoungy;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i:nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
package com.oyoungy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.largestNumber(new int[]{10, 2}));
        System.out.println(ans.largestNumber(new int[]{0, 0}));
    }
    public String largestNumber(int[] nums) {
        String[] tmp = new String[nums.length];
        for (int i=0; i<tmp.length; i++)
            tmp[i] = String.valueOf(nums[i]);
        StringBuilder sb = new StringBuilder();
        Arrays.sort(tmp, (a, b)->{
            String s1 = a+b, s2 = b+a;
            return s2.compareTo(s1);
        });

        if(tmp[0].equals("0")) return "0";

        for(int i=0; i<nums.length; i++){
            sb.append(tmp[i]);
        }
        return sb.toString();
    }
}
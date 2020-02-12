package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        ans[0] = 1;
        ans[1] = numbers.length;
        int tmp = numbers[ans[0]-1]+numbers[ans[1]-1];
        while (tmp != target &&ans[0]<ans[1]){
            if(tmp>target)
                ans[1]--;
            else if(tmp<target)
                ans[0]++;
            tmp = numbers[ans[0]-1]+numbers[ans[1]-1];
        }
        return ans;
    }
}
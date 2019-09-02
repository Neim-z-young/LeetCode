package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        List<List<Integer>>  lists = ans.permuteUnique(new int[]{1, 2, 3});
        System.out.println();
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  //排序，便于去除组合中的重复值
        boolean[] flags = new boolean[nums.length];
        return permute(nums, flags, 0);
    }

    //假设 nums[] 已排序
    private List<List<Integer>> permute(int[] nums, boolean[] flags, int len){
        List<List<Integer>> ans = new ArrayList<>();
        if(len == nums.length) {
            return ans;
        }
        for(int i=0; i<nums.length; ){
            if(!flags[i]){
                int oldI = i;
                flags[oldI] = true;  //防止元素在子序列中重复计算
                //排除重复
                do{
                    i++;
                } while (i<nums.length && nums[i]==nums[i-1]);
                List<List<Integer>> temp = permute(nums, flags, len+1);
                if(temp.size()==0){
                    ArrayList<Integer> temp2 = new ArrayList<>();
                    temp2.add(nums[oldI]);
                    ans.add(temp2);
                }else{
                    for(int j=0; j<temp.size(); j++){
                        List<Integer> temp2 = temp.get(j);
                        temp2.add(0, nums[oldI]);
                        ans.add(temp2);
                    }
                }
                flags[oldI] = false;
            }else {
                i++;
            }
        }
        return ans;
    }
}
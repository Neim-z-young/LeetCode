package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ans.subsets(new int[]{1, 2, 3, 4});
        System.out.println();
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> chessboard[][] = new List[nums.length+1][nums.length+1], ans = new ArrayList<>();
        for(int i=0; i<nums.length+1; i++){
            dpSolve(nums, nums.length, i, chessboard);
            for(List list:chessboard[nums.length][i]){
                ans.add(list);
            }
        }
        return ans;
    }
    //dp solution
    private void dpSolve(int[] nums, int n, int k, List<List<Integer>>[][] chessboard){

        List<List<Integer>> ans = new ArrayList<>();
        if(k!=0) {
            for (int i = n; i >= k; i--) {
                if (chessboard[i - 1][k - 1] == null) {
                    dpSolve(nums, i - 1, k - 1, chessboard);
                }
                for (List list : chessboard[i - 1][k - 1]) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(nums[i - 1]);
                    ans.add(temp);
                }
            }
        }else {
            ans.add(new ArrayList<>());
        }
        chessboard[n][k] = ans;
    }
}
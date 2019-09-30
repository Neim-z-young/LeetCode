package com.oyoungy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ans.combine(4,3);
        System.out.println();
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = combine(1, n, k);
       return ans;
    }

    /**
     * using recursive
     * @param start
     * @param end
     * @param k
     * @return
     */
    private List<List<Integer>> combine(int start, int end, int k){
        List<List<Integer>> ans = new LinkedList<>();
        if(k==0) return ans;
        if(k==1){
            for(int i=start; i<=end; i++){
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                ans.add(temp);
            }
        }else if(k==2){  //简化了递归时遇到k==1时再进入递归的步骤
            for(int i=start; i<=end-k+1; i++){
                for(int j=i+1; j<=end; j++){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }else {
            for(int i=start; i<=end-k+1; i++){
                List<List<Integer>> tempLists = combine(i+1, end, k-1);
                for(List list:tempLists){
                    list.add(0, i);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    //TODO using DP to optimize the time spent
}
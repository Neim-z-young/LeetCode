package com.oyoungy;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        return solveCombinaiton(k, n, 1);
    }

    private List<List<Integer>> solveCombinaiton(int k, int n, int index){
        List<List<Integer>> ans = new LinkedList<>();
        if (k==1){
            for(int i = index; i<10; i++){
                if(i==n){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(i);
                    ans.add(tmp);
                    break;
                }
            }

        }else {
            for(int i=index; i<10; i++){
                List<List<Integer>> tmpList = solveCombinaiton(k-1, n-i, i+1);
                if(!tmpList.isEmpty()){
                    for (List<Integer> list:tmpList){
                        list.add(0, i);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
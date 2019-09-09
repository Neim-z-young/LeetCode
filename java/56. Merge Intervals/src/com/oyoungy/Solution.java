package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length==0) return intervals;
        //按下界排序
        Arrays.sort(intervals, (a1, a2)->{
            if(a1[0]>a2[0]){
                return 1;
            }else if(a1[0]<a2[0]){
                return -1;
            }else {
                return 0;
            }
        });
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for(int i=0; i<intervals.length;){
            int lower = intervals[i][0];
            int upper = intervals[i][1];
            int j;
            for(j = i+1; j<intervals.length; j++){
                if(upper<intervals[j][0]){
                    break;
                }else if(upper < intervals[j][1]){
                    upper = intervals[j][1];
                }
            }
            i=j;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(lower);
            temp.add(upper);
            arrayLists.add(temp);
        }
        int ans[][] = new int[arrayLists.size()][2];
        for(int i=0; i<arrayLists.size(); i++){
            ans[i][0] = arrayLists.get(i).get(0);
            ans[i][1] = arrayLists.get(i).get(1);
        }
        return ans;
    }
}
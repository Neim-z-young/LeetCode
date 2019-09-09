package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ans.insert(new int[][]{{2,5}, {6,7}, {8,9}}, new int[]{0,1});
        System.out.println();
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length==0) return new int[][]{newInterval};
        List<int[]> ans = new ArrayList<>();
        int j=0;
        //比新间隔的lower还小的部分
        while (j<intervals.length && intervals[j][1]<newInterval[0]){
            ans.add(intervals[j++]);
        }
        //插入新间隔可能有重叠的部分
        if(j<intervals.length){
            if(intervals[j][0]>newInterval[1]){ //无重叠
                ans.add(newInterval);
            }else {
                int lower = Math.min(intervals[j][0], newInterval[0]);
                int upper = Math.max(intervals[j][1], newInterval[1]);
                while (++j<intervals.length &&upper>=intervals[j][0]){
                    upper = Math.max(intervals[j][1], upper);
                }
                ans.add(new int[]{lower, upper});
            }

        }else {
            ans.add(newInterval);
        }
        //比插入新间隔的upper还大的部分
        while (j<intervals.length){
            ans.add(intervals[j++]);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
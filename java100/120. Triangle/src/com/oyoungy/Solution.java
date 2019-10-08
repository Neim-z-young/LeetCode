package com.oyoungy;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return dpSolve(triangle);
    }

    /**
     * dp 方法
     * @param triangle
     * @return
     */
    private int dpSolve(List<List<Integer>> triangle){
        if(triangle==null || triangle.size()==0) return 0;
        int[][] dp = new int[triangle.size()+1][triangle.size()];
        dp[1][0] = triangle.get(0).get(0);
        for(int i=2; i<=triangle.size(); i++){
            for(int j=0; j<i; j++){
                int upV = j==i-1?Integer.MAX_VALUE:dp[i-1][j];
                int leftUpV = j==0?Integer.MAX_VALUE:dp[i-1][j-1];
                dp[i][j] = Math.min(leftUpV, upV)+triangle.get(i-1).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<triangle.size(); i++){
            min = Math.min(min, dp[triangle.size()][i]);
        }
        return min;
    }

    private int minValue = Integer.MAX_VALUE;

    /**
     * 递归方法，无剪枝
     * @param triangle
     * @param cur
     * @param index
     * @param level
     * @return
     */
    private int minimumTotal(List<List<Integer>> triangle, int cur, int index, int level){
        if(triangle==null || level==triangle.size()){
            minValue = Math.min(cur, minValue);
            return minValue;
        }
        cur += triangle.get(level).get(index);
        int t = minimumTotal(triangle, cur, index, level+1);
        t = Math.min(t, minimumTotal(triangle, cur, index+1, level+1));
        minValue = Math.min(t, minValue);
        return minValue;
    }
}
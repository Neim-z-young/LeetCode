package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * 使用DP求解
     * DP[i][j] = min(DP[i-1][j], DP[i][j-1]) + value[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int DP[][] = new int[m+1][n+1];
        //初始化
        for(int i=0; i<m+1; i++){
            DP[i][0] = Integer.MAX_VALUE;
        }
        for(int i=0; i<n+1; i++){
            DP[0][i] = Integer.MAX_VALUE;
        }
        DP[1][0] = 0;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                DP[i][j] = Math.min(DP[i-1][j], DP[i][j-1]) + grid[i-1][j-1];
            }
        }
        return DP[m][n];
    }
}
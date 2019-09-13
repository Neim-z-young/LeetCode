package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * 寻找动态规划的规律
     * 从简单例子中发现问题由许多个子问题叠加得到
     * DP(1, n) = 1
     * DP(m, 1) = 1
     * DP(m, n) = DP(m-1, 1) + DP(m-1, 2) + ... + DP(m-1, n-1) + DP(m-1, n)
     *          = DP(m, n-1) + DP(m-1, n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int DP[][] = new int[m+1][n+1];
        //初始化
        for(int i=0; i<n+1; i++){
            DP[1][i] = 1;
        }
        for(int i=0; i<m+1; i++){
            DP[i][1] = 1;
        }
        //递推公式
        for(int i=2; i<m+1; i++){
            for (int j=2; j<n+1; j++){
                DP[i][j] = DP[i][j-1] + DP[i-1][j];
            }
        }
        return DP[m][n];
    }
}
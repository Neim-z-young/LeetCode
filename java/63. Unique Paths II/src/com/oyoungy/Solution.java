package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));
    }

    /**
     * 寻找动态规划的规律
     * 从简单例子中发现问题由许多个子问题叠加得到
     * if obstacleGrid[m][n]==1 then
     *    DP(m,n) = 0
     * else
     *    DP(m, n) = DP(m-1, 1) + DP(m-1, 2) + ... + DP(m-1, n-1) + DP(m-1, n)
     *             = DP(m, n-1) + DP(m-1, n)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int DP[][] = new int[m+1][n+1];
        //初始化
        DP[0][1] = 1;
        //递推公式
        for(int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if(obstacleGrid[i-1][j-1]==1){
                    DP[i][j] = 0;
                }else {
                    DP[i][j] = DP[i][j-1] + DP[i-1][j];
                }
            }
        }
        return DP[m][n];
    }
}
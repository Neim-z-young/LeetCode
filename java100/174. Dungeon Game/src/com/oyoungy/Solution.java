package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int[][] dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(ans.calculateMinimumHP(dungeon));
    }

    /**
     * dp[i][j]表示从[i][j]方格至[m-1][n-1]方格所需的最少生命值
     * bottom up method
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (i == m - 1 && j == n - 1)
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == m - 1)
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                else if (j == n - 1)
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                else
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
        return dp[0][0];
    }
}
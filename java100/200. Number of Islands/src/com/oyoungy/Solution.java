package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] map = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(grid[i][j]=='1' && !map[i][j]){
                    count++;
                    //expand
                    expand(grid, map, i, j);
                }
            }
        }
        return count;
    }

    private void expand(char[][] grid, boolean map[][], int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i<0||i>=m ||j<0||j>=n) return;
        if(grid[i][j]=='1' && !map[i][j]){
            map[i][j]=true;
            expand(grid, map, i-1, j);
            expand(grid, map, i+1, j);
            expand(grid, map, i, j-1);
            expand(grid, map, i, j+1);
        }
    }
}
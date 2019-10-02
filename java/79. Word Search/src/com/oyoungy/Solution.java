package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        int m=board.length, n = board[0].length;
        boolean used[][] = new boolean[m][n], contained = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(contained = exist(board, i, j, m, n, used, word, 0)){
                    return contained;
                }
            }
        }
        return contained;
    }
    private boolean exist(char[][] board, int row, int col, int m, int n, boolean[][] used, String word, int index){
        if(index == word.length()) return true;
        if(row<0 || row>=m || col<0 || col>=n || used[row][col] || board[row][col]!=word.charAt(index)) return false;
        boolean ans = false;
        used[row][col] = true;
        //up
        ans = ans|| exist(board, row-1, col, m, n, used, word, index+1);
        //down
        ans = ans|| exist(board, row+1, col, m, n, used, word, index+1);
        //left
        ans = ans|| exist(board, row, col-1, m, n, used, word, index+1);
        //right
        ans = ans|| exist(board, row, col+1, m, n, used, word, index+1);
        used[row][col] = false;
        return ans;
    }
}
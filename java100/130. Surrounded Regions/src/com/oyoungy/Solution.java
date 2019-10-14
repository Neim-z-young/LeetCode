package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        boolean[][] isBounded = new boolean[board.length][board[0].length];
        //expand
        //col 0
        for(int i=0; i<board.length; i++){
            if(board[i][0]=='O'){
                expand(board, isBounded, i, 0);
            }
        }
        //col n-1
        for(int i=0; i<board.length; i++){
            if(board[i][board[0].length-1]=='O'){
                expand(board, isBounded, i, board[0].length-1);
            }
        }
        //row 0
        for(int i=0; i<board[0].length; i++){
            if(board[0][i]=='O'){
                expand(board, isBounded, 0, i);
            }
        }
        //row m-1
        for(int i=0; i<board[0].length; i++){
            if(board[board.length-1][i]=='O'){
                expand(board, isBounded, board.length-1, i);
            }
        }
        for(int i=1; i<board.length-1; i++){
            for(int j=1; j<board[0].length-1; j++){
                if(board[i][j]=='O' && !isBounded[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    //suppose board is valid
    private void expand(char[][] board, boolean[][] isBounded, int row, int col){
        int m = board.length, n = board[0].length;
        //up
        if(row-1>=0 && board[row-1][col]=='O' && !isBounded[row-1][col]){
            isBounded[row-1][col]=true;
            expand(board, isBounded, row-1, col);
        }
        //down
        if(row+1<m && board[row+1][col]=='O' && !isBounded[row+1][col]){
            isBounded[row+1][col]=true;
            expand(board, isBounded, row+1, col);
        }
        //left
        if(col-1>=0 && board[row][col-1]=='O' && !isBounded[row][col-1]){
            isBounded[row][col-1]=true;
            expand(board, isBounded, row, col-1);
        }
        //right
        if(col+1<n && board[row][col+1]=='O' && !isBounded[row][col+1]){
            isBounded[row][col+1]=true;
            expand(board, isBounded, row, col+1);
        }
    }
}
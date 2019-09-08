package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        //ans.solveNQueens(4);
        int arr[] = new int[10];
        System.out.println(arr[0]);
    }

    public List<List<String>> solveNQueens(int n) {
        if(n<=0) return null;
        int position[] = new int[n];
        for(int i=0; i<n; i++){
            position[i] = -1;
        }
        return solveNQueens(position, 0);

    }
    private List<List<String>> solveNQueens(int[] position, int index){
        List<List<String>> ans = new ArrayList<>();
        if(index == position.length){
            ans.add(generate(position));
            return ans;
        }
        //对棋盘上的每一列
        for(int i=0; i<position.length; i++){
            boolean conflict = false;
            for(int j=index-1; j>=0; j--){
                //第i列或对角线上有冲突
                int offset_row = Math.abs(j-index);
                int offset_col = Math.abs(position[j]-i);
                if(position[j]==i || offset_col==offset_row){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                position[index] = i;
                List<List<String>> temp = solveNQueens(position, index+1);
                for(int j = 0; j<temp.size(); j++){
                    ans.add(temp.get(j));
                }
                position[index] = -1;
            }
        }
        return ans;
    }
    private List<String> generate(int[] position){
        List<String> ans = new ArrayList<>();
        for(int i=0; i<position.length; i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<position[i]; j++){
                temp.append('.');
            }
            temp.append('Q');
            for(int j=position[i]+1; j<position.length; j++){
                temp.append('.');
            }
            ans.add(temp.toString());
        }
        return ans;
    }

    //从棋盘中判断有无问题
    private boolean isValidSolution(char[][] chessboard, int row, int col){
        //in the same row or the same column
        for(int i=0; i<chessboard.length; i++){
            if(chessboard[row][i]=='Q' || chessboard[i][col]=='Q'){
                return false;
            }
        }
        //in the diagonal left up -> right down
        int min = Math.min(row, col), max = Math.max(row, col);
        for(int i=0; i<chessboard.length + min - max; i++){
            if(chessboard[i + row-min][i+col-min]=='Q'){
                return false;
            }
        }
        int start = Math.min(chessboard.length-row, col)-1;
        int end = Math.min(chessboard.length-col, row);

        for(int i=0; i<start+end; i++){
            if(chessboard[row+start-i][col-start+i]=='Q'){
                return false;
            }
        }
        return true;
    }
}
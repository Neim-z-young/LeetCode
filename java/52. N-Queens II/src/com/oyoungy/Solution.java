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

    public int totalNQueens(int n) {
        if(n<=0) return 0;
        int position[] = new int[n];
        for(int i=0; i<n; i++){
            position[i] = -1;
        }
        return solveNQueens(position, 0);

    }
    private int solveNQueens(int[] position, int index){
        if(index == position.length){
            return 1;
        }
        int ans = 0;
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
                ans += solveNQueens(position, index+1);
                position[index] = -1;
            }
        }
        return ans;
    }
}
package com.oyoungy;


public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0) return;
        int m = matrix.length, n = matrix[0].length;
        int[] zeroRow = new int[m], zeroCol = zeroCol = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    zeroRow[i] = 1;
                    zeroCol[j] = 1;
                }
            }
        }
        for(int i=0; i<m; i++){
            if(zeroRow[i]==1){
                for(int j=0; j<n; j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0; j<n; j++){
            if(zeroCol[j]==1){
                for(int i=0; i<m; i++){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
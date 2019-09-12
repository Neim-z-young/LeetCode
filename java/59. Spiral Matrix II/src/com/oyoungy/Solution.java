package com.oyoungy;


public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int level = 0, value = 1;

        while (level<n/2){
            //left to right
            for(int i=level; i<n-level-1; i++){
                matrix[level][i] = value++;
            }
            //up to down
            for(int i=level; i<n-level-1; i++){
                matrix[i][n-level-1] = value++;
            }
            //right to left
            for(int i=n-level-1; i>level; i--){
                matrix[n-level-1][i] = value++;
            }
            //down to up
            for(int i=n-level-1; i>level; i--){
                matrix[i][level] = value++;
            }
            level++;
        }
        if(n%2==1){
            matrix[n/2][n/2] = value;
        }
        return matrix;
    }
}
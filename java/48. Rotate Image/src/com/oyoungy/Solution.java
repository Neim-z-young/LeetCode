package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int[][] max = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};

        ans.rotate(max);
        System.out.println();
    }

    //按顺时针旋转90度
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0) return;
        int n = matrix.length;
        int inx = 0;
        while (inx < n/2){
            for(int i=inx; i<n-1 -inx; i++){
                int fourCount = 0, row = inx, col = i;
                int val = matrix[row][col];
                while (fourCount++<4) {
                    int temp = row;
                    row = col;
                    col = n - 1 - temp;
                    int tempVal = matrix[row][col];
                    matrix[row][col] = val;
                    val = tempVal;
                }
            }
            inx++;
        }
    }
}

package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    //binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lowRow = 0, highRow = m, midRow = 0;
        while (lowRow<highRow){
            midRow = lowRow + (highRow-lowRow)/2;
            if(matrix[midRow][0] > target){
                highRow = midRow;
            }else if(matrix[midRow][n-1] < target){
                lowRow = midRow+1;
            }else {
                break;
            }
        }
        int low = 0, high = n, mid = 0;
        while (low<high){
            mid = low + (high-low)/2;
            if(matrix[midRow][mid] > target){
                high = mid;
            }else if(matrix[midRow][mid] < target){
                low = mid + 1;
            }else {
                break;
            }
        }
        return matrix[midRow][mid]==target;
    }
}
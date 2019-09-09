package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix==null || matrix.length==0) return ans;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, counts = Math.min(m, n);
        while (start<counts/2){
            //left -> right
            for(int i=start; i<n-start-1; i++){
                ans.add(matrix[start][i]);
            }
            //up -> down
            for(int j=start; j<m-start-1; j++){
                ans.add(matrix[j][n-start-1]);
            }
            //right -> left
            for(int i=n-start-1; i>start; i--){
                ans.add(matrix[m-start-1][i]);
            }
            //down -> up
            for(int j=m-start-1; j>start; j--){
                ans.add(matrix[j][start]);
            }
            start++;
        }
        //奇数时，多一次
        if((counts&1)==1){
            if(counts==m){
                for(int i=start; i<n-start; i++){
                    ans.add(matrix[start][i]);
                }
            }else {
                for(int j=start; j<m-start; j++){
                    ans.add(matrix[j][start]);
                }
            }
        }
        return ans;
    }
}
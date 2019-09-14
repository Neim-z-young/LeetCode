package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * DP solution
     *   s1[i] compare with s2[j]
     *   if match : DP[i][j] = DP[i-1][j-1]
     *   else find min in below
     *          delete s[j]: DP[i][j] = DP[i][j-1] +1
     *          insert in j: DP[i][j] = DP[i-1][j] +1
     *          replace : DP[i][j] = DP[i-1][j-1] +1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int DP[][] = new int[m+1][n+1];
        //初始化
        for (int i=0; i<m+1; i++){
            DP[i][0] = i;
        }
        for (int i=0; i<n+1; i++){
            DP[0][i] = i;
        }
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    DP[i][j] = DP[i-1][j-1];
                }else {
//                    int del = DP[i][j-1]+1;
//                    int ins = DP[i-1][j]+1;
//                    int rep = DP[i-1][j-1]+1;
                    DP[i][j] = Math.min(DP[i][j-1], DP[i-1][j]);
                    DP[i][j] = Math.min(DP[i][j], DP[i-1][j-1])+1;
                }
            }
        }
        return DP[m][n];
    }
}
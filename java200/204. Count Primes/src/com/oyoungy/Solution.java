package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.countPrimes(10));
    }

    /**
     * 埃拉托色尼筛法
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] prime = new boolean[n];
        prime[1] = true;
        for (int i=1; i<n/2 + 1; i++){
            if(!prime[i]){
                int t = i;
                while ((t+=i)<n && t>0) //防止溢出
                    prime[t] = true;
            }
        }
        int count = 0;
        for (int i=1; i<n; i++)
            count+=(prime[i]?0:1);
        return count;
    }

    /**
     * better
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        if(n<2) return 0;
        boolean[] prime = new boolean[n];
        prime[1] = true;
        int count = 0;
        for (int i=1; i<n; i++){
            if(!prime[i]){
                count++;
                int t = i;
                while ((t+=i)<n && t>0) //防止溢出
                    prime[t] = true;
            }
        }
        return count;
    }
}
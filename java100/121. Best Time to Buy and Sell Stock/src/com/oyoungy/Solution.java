package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int maxProfit(int[] prices) {
        int profit = 0, low = Integer.MAX_VALUE;
        int i=0;
        while (i<prices.length){
            while (i+1<prices.length && prices[i]>prices[i+1]){
                i++;
            }
            if(i==prices.length){
                break;
            }
            low = Math.min(low, prices[i]);
            while (i+1<prices.length && prices[i]<prices[i+1]){
                i++;
            }
            if(i==prices.length){
                break;
            }
            int high = prices[i];
            profit = Math.max(high-low, profit);
            i++;
        }
        return profit;
    }
}
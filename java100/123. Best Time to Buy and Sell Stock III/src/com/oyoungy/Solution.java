package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int len = prices.length, i = 0, low = prices[0], high = prices[0], tempMax = 0;
        int[] pre = new int[len], post = new int[len];
        while (i<len){
            if(high<prices[i]) high = prices[i];
            if(low>prices[i]){
                low = prices[i];
                high = prices[i];
            }

            tempMax = Math.max(tempMax, high-low);
            pre[i] = tempMax;
            i++;
        }

        i=len - 1;
        tempMax = 0;
        low = prices[len-1];
        high = prices[len-1];
        while (i>=0){
            if(low>prices[i]) low = prices[i];
            if(high<prices[i]){
                high = prices[i];
                low = prices[i];
            }

            tempMax = Math.max(tempMax, high-low);
            post[i] = tempMax;
            i--;
        }

        i = 0;
        tempMax = 0;
        while (i<len){
            tempMax = Math.max(tempMax, pre[i]+post[i]);
            i++;
        }
        return tempMax;
    }
}
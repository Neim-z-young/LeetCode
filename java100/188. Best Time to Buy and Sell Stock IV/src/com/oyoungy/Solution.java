package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * 方法0
     * bought[ck]表示当前状态为已启动第ck轮交易
     * sold[ck]表示当前状态为结束第ck轮交易
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0 || k==0) return 0;
        int n = prices.length;
        if(k/2>=n){
            int maxProfit = 0;
            for (int i=1; i<n; i++){
                int diff = prices[i]-prices[i-1];
                if(diff>0){
                    maxProfit+=diff;
                }
            }
            return maxProfit;
        }
        int[] bought = new int[k], sold = new int[k];
        for (int i=0; i<k; i++){
            bought[i] = Integer.MIN_VALUE;
            sold[i] = Integer.MIN_VALUE;
        }
        for (int i=0; i<n; i++){
            bought[0] = Math.max(bought[0], -prices[i]);
            sold[0] = Math.max(sold[0], bought[0]+prices[i]);

            //在时刻范围为0~i时,对之前在时刻0~i-1时求出的交易进行修正
            for(int ck = 1; ck<k; ck++){
                //要不就保留原操作,要不就买入时刻i的股票
                bought[ck] = Math.max(bought[ck], sold[ck-1]-prices[i]);
                //要不就保留原操作,要不就卖出时刻i的股票
                sold[ck] = Math.max(sold[ck], bought[ck]+prices[i]);
            }
        }
        return sold[k-1];
    }

    /**
     * 方法1
     * bought[i]表示
     * sold[i]表示
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {
        int n = prices.length;
        if(k/2>=n){
            int maxProfit = 0;
            for (int i=1; i<n; i++){
                int diff = prices[i]-prices[i-1];
                if(diff>0){
                    maxProfit+=diff;
                }
            }
            return maxProfit;
        }
        int[] bought = new int[n+1], sold = new int[n+1];
        for (int ck = 0; ck<k; ck++){
            bought[0] = Integer.MIN_VALUE;
            for (int i=1; i<n+1; i++){
                //在启动ck轮交易时
                //在时刻i,要不就不买股票, 要不就买股票
                bought[i] = Math.max(bought[i-1], sold[i]-prices[i-1]);
                //关闭第ck轮交易时
                //要不就不买卖股票,要不就卖股票
                sold[i] = Math.max(sold[i-1], bought[i]+prices[i-1]);
            }
        }
        return sold[n];
    }
}
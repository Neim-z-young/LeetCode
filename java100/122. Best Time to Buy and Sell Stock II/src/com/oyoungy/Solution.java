package com.oyoungy;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 错误的思路，导致浪费了许多时间
     */
//    public int maxProfit(int[] prices) {
//        int profit = 0, minLow = -1, maxHigh = -1, tempProfit = 0;
//        int i=0;
//        Stack<Integer> lower = new Stack<>(), higher = new Stack<>();
//        while (i<prices.length){
//            while (i+1<prices.length && prices[i]>prices[i+1]){
//                i++;
//            }
//            if(i==prices.length){
//                break;
//            }
//            if(lower.isEmpty()){
//                minLow = prices[i];
//            }else if(prices[i]<lower.peek()){
//                while (!lower.isEmpty()){
//                    profit +=(higher.pop() - lower.pop());
//                }
//                minLow = prices[i];
//            }
//            lower.push(prices[i]);
//            while (i+1<prices.length && prices[i]<prices[i+1]){
//                i++;
//            }
//            if(i==prices.length){
//                break;
//            }
//            if(!higher.isEmpty() && prices[i]>higher.peek()){
//                while (lower.peek()!=minLow){
//                    lower.pop();
//                    higher.pop();
//                }
//            }
//            higher.push(prices[i]);
//            i++;
//        }
//        return profit;
//    }
}
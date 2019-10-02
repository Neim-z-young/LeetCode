package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            //expand
            int low = i, high = i;
            while (low-1>=0 && heights[low-1]>=heights[i]){
                low--;
            }
            while (high+1<heights.length && heights[high+1]<=heights[i]){
                high++;
            }
            int temp = heights[i]*(high-low+1);
            if(maxArea<temp){
                maxArea = temp;
            }
        }
        return maxArea;
    }
}
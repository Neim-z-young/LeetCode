package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    /*
    Input: [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    //从后往前遍历， 寻找能到达当前终点的最小下标，
    //将最小下标更新为新的终点
    //算法复杂度偏高O(n^2)
    public int jump(int[] nums) {
        int last = nums.length-1;
        int steps = 0;
        while (last>0){
            steps++;
            for(int i=0; i<last; i++){
                if(nums[i]+i>=last){
                    last = i;
                    break;
                }
            }
        }
        return steps;
    }

    //O(n)算法，使用双指针


}
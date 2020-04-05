package com.oyoungy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<=0) return new int[0];
        int[] inDegree = new int[numCourses], ans = new int[numCourses];
        for(int[] pre:prerequisites){
            inDegree[pre[0]]++;
        }
        Queue<Integer> topLogicQ = new LinkedList<>();
        for (int i = 0; i<numCourses; i++){
            if(inDegree[i]==0){
                topLogicQ.offer(i);
            }
        }
        int n = 0;
        while (!topLogicQ.isEmpty()){
            int c = topLogicQ.poll();
            ans[n++] = c;
            for(int[] pre:prerequisites){
                if(pre[1]==c && --inDegree[pre[0]]==0){
                    topLogicQ.offer(pre[0]);
                }
            }
        }

        return n==numCourses?ans:new int[0];
    }
}
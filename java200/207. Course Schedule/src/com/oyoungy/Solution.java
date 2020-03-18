package com.oyoungy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.canFinish(2, new int[][]{{0, 1}, {1, 0}}));
    }

    // time limit exceed
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[][] dp = new int[numCourses][numCourses];
        boolean[] canF = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            dp[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        int count = 0;
        while (count < numCourses) {
            int t = findNoneFAndNonePreCourse(numCourses, dp, canF);
            if (t == -1)
                return false;
            for (int i = 0; i < numCourses; i++)
                dp[t][i] = 0;
            canF[t] = true;
            count++;
        }
        return true;
    }

    private int findNoneFAndNonePreCourse(int n, int[][] dp, boolean[] canF) {
        for (int i = 0; i < n; i++) {
            if (!canF[i]) {
                int j = 0;
                for (; j < n; j++)
                    if (dp[j][i] == 1)
                        break;
                if (j != n)
                    return i;
            }
        }
        return -1;
    }

    //队列实现拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            courses[prerequisites[i][0]]++;
        Queue<Integer> curCourse = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == 0)
                curCourse.offer(i);
        }
        int n = numCourses;
        while (curCourse.size() != 0) {
            n--;
            int t = curCourse.poll();
            for (int[] edge:prerequisites){
                if(edge[1]==t){
                    if((--courses[edge[0]])==0){
                        curCourse.offer(edge[0]);
                    }
                }
            }
        }
        return n==0;
    }
}
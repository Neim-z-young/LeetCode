package com.oyoungy;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int[] ar = new int[]{1,2,3,4,5,6,7};
        ans.rotate(ar, 3);
        ans.rotate(ar, 7);
        ans.rotate(ar, 4);

        System.out.println();
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %=n;
        int count = 0;
        for (int start=0; count<n; start++){
            int cur = start;
            int pre = nums[cur];
            do{
                int next = (cur+k)%n;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
                count++;
            }while (start!=cur);
        }
    }

    /**
     * TODO
     * reverse (0~n)
     * reverse(0~k)
     * reverse(k~n)
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {

    }
}
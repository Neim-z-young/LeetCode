package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diffs[] = new int[gas.length];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = gas[i] - cost[i];
        }
        int start = -1, acc = 0, count = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (acc <= 0 && diffs[i] > 0) {
                start = i;
                acc = diffs[i];
            } else {
                acc += diffs[i];
            }
            count += diffs[i];
        }
        return count < 0 ? -1 : start;
    }
}
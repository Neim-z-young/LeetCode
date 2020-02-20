package com.oyoungy;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return isHappy(set, n);
    }
    public boolean isHappy(HashSet<Integer> set, int n) {
        if(n==1)
            return true;
        if(set.contains(n))
            return false;
        set.add(n);
        int tmp = 0;
        while (n!=0){
            int mod = n%10;
            tmp+=(mod*mod);
            n/=10;
        }
        return isHappy(set, tmp);
    }
}
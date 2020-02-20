package com.oyoungy;

import java.util.BitSet;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.getLeftOne(1073741824));
        System.out.println(ans.getLeftOne(1));
        System.out.println(ans.getLeftOne(15));
        System.out.println(ans.getLeftOne(Integer.MIN_VALUE));
        System.out.println(ans.getLeftOne(2147483646));
        System.out.println(ans.getLeftOne(2147483647));
        System.out.println(ans.rangeBitwiseAnd1(2147483646, 2147483647));
        System.out.println(ans.rangeBitwiseAnd2(2147483646, 2147483647));
        System.out.println(ans.rangeBitwiseAnd(0, 2147483647));
        System.out.println(ans.rangeBitwiseAnd2(0, 2147483647));
    }

    /**
     * brute force
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m>n || m<0) return 0;
        int ans = Integer.MAX_VALUE;
        for(long i=m; i<=n; i++){
            ans&=i;
        }
        return ans;
    }

    /**
     * improved brute force
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd1(int m, int n) {
        if(m>n || m<0) return 0;
        int b1 = getLeftOne(m), b2 = getLeftOne(n);
        if(b1>b2) return 0;
        int ans = Integer.MAX_VALUE;
        for(long i=m; i<=n; i++){
            ans&=i;
        }
        return ans;
    }
    private int getLeftOne(int n){
        int bit = 0;
        while (n!=0){
            n>>>=1;
            bit++;
        }
        return 32 - bit;
    }

    /**
     * simple optimize
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd2(int m, int n) {
        return helper(m, n, 32);
    }
    public int helper(int m, int n, int maxBit) {
        if(m>n || m<0 || maxBit<=0) return 0;
        int b1 = getLeftOne(maxBit, m), b2 = getLeftOne(maxBit, n);
        if(b1>b2 || b1==maxBit) {
            return 0;
        } else {
            int ans = 1<<(maxBit- b1-1);
            ans^=helper(m-ans, n-ans, maxBit-b1-1);
            return ans;
        }
    }
    private int getLeftOne(int maxBit, int n){
        int bit = 0;
        while (n!=0){
            n>>>=1;
            bit++;
        }
        return maxBit - bit;
    }
}
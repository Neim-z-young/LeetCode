package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * Input:  00000010100101000001111010011100
     * Output: 00111001011110000010100101000000
     * @param n
     * @return
     */

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int bits = 32;
        for (int i=0; i<bits/2;i++){
            int b1, b2;
            b1 = getBit(n, i);
            b2 = getBit(n, bits-i-1);
            n = setBit(n, i, b2);
            n = setBit(n, bits-i-1, b1);
        }
        return n;
    }

    private int getBit(int n, int bit) {
        int tmp = 1;
        tmp <<= bit;
        return ((tmp & n) == 0) ? 0 : 1;
    }

    /**
     * @param n
     * @param bit
     * @param v   only be 0 or 1
     * @return
     */
    private int setBit(int n, int bit, int v) {
        if (v != 0 && v != 1) return n;
        int tmp = 1;
        tmp <<= bit;
        tmp &= n;
        if ((tmp != 0 ? 1 : 0) == v)
            return n;
        int remain = n - tmp;
        return remain + ((tmp == 0) ? 1 << bit : 0);
    }

    /**
     * easy solution
     * @param n
     * @return
     */
    public int reverseBits1(int n) {
        int res = 0;
        for (int i=0; i<32;i++){
            int right = n&1;
            n>>=1;
            res = (i<31)?(res|right)<<1:(res|right);
        }
        return res;
    }
}
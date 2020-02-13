package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.trailingZeroes(3));
        System.out.println(ans.trailingZeroes(5));
        System.out.println(ans.trailingZeroes(30)); //out = 7
        //System.out.println(ans.trailingZeroes(701));
    }

    /**
     * 每5^x的倍数都可产生0
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; ) {
            ans += n / i;
            if (Integer.MAX_VALUE / 5 < i) break;
            else i *= 5;
        }
        return ans;
    }
}
package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2}));
    }

    //将所有数字的二进制数中的各位叠加，再对3取模，组合起来就得到了出现一次的数
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            char[] s = Integer.toBinaryString(nums[i]).toCharArray();
            for (int j = 0; j <s.length; j++) {
                bits[32 - s.length + j] += (s[j] - '0');
            }
        }
        int ans = 0;
        boolean neg = bits[0]%3 == 1;
        for(int i=1; i<bits.length; i++){
            bits[i] %= 3;
            ans = ans*2 + (neg?invert(bits[i]) : bits[i]);
        }
        if (neg) {
            ans = -ans-1;
        }
        return ans;
    }

    private int invert(int bit) {
        if (bit == 1) return 0;
        else return 1;
    }
}
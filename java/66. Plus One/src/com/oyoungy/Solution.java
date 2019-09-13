package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length, index = n-1;
        boolean carry = false;
        if(++digits[index]>9){
            carry = true;
        }
        while (carry){
            digits[index--]%=10;
            if(index>=0){
                if(++digits[index]<10){
                    carry = false;
                }
            }else break;
        }
        //数组长度增加
        if(carry){
            int temp[] = new int[n+1];
            for(int i = 0; i<n; i++){
                temp[i+1] = digits[i];
            }
            temp[0] = 1;
            digits = temp;
        }
        return digits;
    }
}
package com.oyoungy;

import java.sql.Time;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int n = Integer.MIN_VALUE;
        int m = Integer.MAX_VALUE;
        System.out.println(-m);
        System.out.println(-n);  //对int取负数是对其位取反，再+1 intMin = 1000000..000  => 1000000..000
        int[] array = new int[10000000];
        Random random = new Random();
        for(int i=0 ;i<array.length; i++){
            array[random.nextInt(array.length)] = 1;
        }
        int count = 0;
        for(int i=0; i<array.length; i++){
            count+=array[i];
        }
        System.out.println(count);
    }

    public double myPow(double x, int n) {
        if(x<1e-8 && x>-1e-8) return 0.;
        if(n==0) return 1.;
        boolean negative = n<0, isOverflow = false;

        if(n==Integer.MIN_VALUE){
            n++;
            isOverflow = true;
        }
        if(negative){
            n = -n;
        }
        double ans = recursivePow(x, n);
        if(isOverflow){
            ans*=x;
        }
        if(negative) ans = 1./ans;
        return ans;
    }

    // n is positive
    public double recursivePow(double x, int n){
        if(n==0) return 1.;
        double ans = recursivePow(x, n/2);
        ans*=ans;
        if((n&1)==1){
            ans*=x;
        }
        return ans;
    }
}
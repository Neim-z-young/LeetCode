package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.convertToTitle(701));
        System.out.println(ans.convertToTitle(182));
        System.out.println(ans.convertToTitle(183));
        System.out.println(ans.convertToTitle(729));
        System.out.println(ans.convertToTitle(676));
        System.out.println(ans.convertToTitle(702));
    }
    public String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        if (n<=0) return sb.toString();
        boolean flag = false;
        while (n>0){
            if(n%26==0){
                sb.insert(0, 'Z');
                n-=26;
            } else{
                sb.insert(0, (char)(n%26+'A'-1));
            }
            n = n/26;
        }
        return sb.toString();
    }

    /**
     * more simple than above solution
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n<=0) return sb.toString();
        boolean flag = false;
        while (n>0){
            n--;
            sb.insert(0, (char)(n%26+'A'));
            n = n/26;
        }
        return sb.toString();
    }
}
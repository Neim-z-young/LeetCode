package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.compareVersion("0.1", "1.1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\."), s2 = version2.split("\\.");
        int length = Math.max(s1.length, s2.length);
        for (int i=0; i<length; i++){
            int v1 = 0, v2 = 0;
            if(i<s1.length)
                v1=Integer.parseInt(s1[i]);
            if(i<s2.length)
                v2 = Integer.parseInt(s2[i]);
            if(v1>v2)
                return 1;
            else if(v1<v2)
                return -1;
        }
        return 0;
    }
}
package com.oyoungy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int minLen = Integer.MAX_VALUE, maxLen = 0, cache[] = new int[s.length()];
        for (String ss : wordDict) {
            set.add(ss);
            maxLen = Math.max(maxLen, ss.length());
            minLen = Math.min(minLen, ss.length());
        }
        Arrays.fill(cache, -1);  //添加缓存，避免回溯时重复计算，造成时间超限
        return wordBreak(s, 0, set,  cache, minLen, maxLen);
    }

    private boolean wordBreak(String s, int index, HashSet<String> set, int[] cache, int minLen, int maxLen) {
        if(index==s.length()) return true;
        if(cache[index]!=-1){
            return cache[index] == 1;
        }
        boolean res = false;
        for (int j = minLen; index+j <= s.length() && j <= maxLen; j++) {
            if (set.contains(s.substring(index, index + j))) {
                res = wordBreak(s, index + j, set, cache, minLen, maxLen);
                if(res)
                    break;
            }
        }
        cache[index] = res?1:0;
        return res;
    }
}
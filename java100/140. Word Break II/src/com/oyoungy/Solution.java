package com.oyoungy;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int minLen = Integer.MAX_VALUE, maxLen = 0;
        for (String ss : wordDict) {
            set.add(ss);
            maxLen = Math.max(maxLen, ss.length());
            minLen = Math.min(minLen, ss.length());
        }
        boolean isValid[] = new boolean[s.length()+1];
        isValid[0] = true;
        for(int i=1; i<isValid.length; i++){ //添加简单判断存在性，避免无用计算，造成时间超限
            for(String ss:set){
                if(i>=ss.length() && s.substring(i-ss.length(), i).equals(ss)){
                    if(isValid[i]=isValid[i-ss.length()]){
                        break;
                    }
                }
            }
        }

        List<List<String>> cache = new ArrayList<>(s.length()+1);
        for(int i=0; i<s.length()+1; i++){
            cache.add(new ArrayList<>());
        }
        return wordBreakDP(s, set,  cache, isValid);
    }
    //使用String时，每次都要构造新的对象，会拖慢算法
    private List<String> wordBreakDP(String s, Set<String> set, List<List<String>> cache, boolean[] isValid){
        if(!isValid[s.length()]) return new ArrayList<>();
        for(int i=1; i<cache.size(); i++){
            if(isValid[i]){
                List<String> t = cache.get(i);
                for(String ss:set){
                    if(i>=ss.length() && s.substring(i-ss.length(), i).equals(ss)) {
                        if (i > ss.length()) {
                            List<String> temp = cache.get(i - ss.length());
                            for (String str : temp) {
                                t.add(str + " " + ss);
                            }

                        } else if (i == ss.length()) {
                            t.add(ss);
                        }
                    }
                }
            }
        }
        return cache.get(s.length());
    }

//      //dfs实现方式，未考虑完善
//    private List<String> wordBreakDFS(String s, int index, Set<String> set, List<List<String>> cache, int minLen, int maxLen){
//        List<String> ans = new ArrayList<>();
//        if(index==s.length()) return ans;
//        boolean res = false;
//        for (int j = minLen; index+j <= s.length() && j <= maxLen; j++) {
//            if (set.contains(s.substring(index, index + j))) {
//                if(index!=0){
//
//                }
//                List<String> temp = cache.get(index);
//
//                res = wordBreak(s, index + j, set, cache, minLen, maxLen);
//                if(res)
//                    break;
//            }
//        }
//        cache[index] = res?1:0;
//        return res;
//    }
}
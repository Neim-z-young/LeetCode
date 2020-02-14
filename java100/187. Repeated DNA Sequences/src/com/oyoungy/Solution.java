package com.oyoungy;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        List list = ans.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        List list2 = ans.findRepeatedDnaSequences2("AAAAAAAAAAA");
        System.out.println();
    }

    //using space to exchange time
    public List<String> findRepeatedDnaSequences2(String s) {

        Set<String> set = new HashSet<>(), subStrSet = new HashSet<>();
        final int LEN = 10;
        for(int i=0; i<s.length()-LEN + 1; i++){
            String sub = s.substring(i, i+LEN);
            if(!set.contains(sub))
                if(subStrSet.contains(sub))
                    set.add(sub);
                else
                    subStrSet.add(sub);
        }
        List<String> list = new ArrayList<>(set.size());
        list.addAll(set);
        return list;
    }

    // time limit exceeded
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        final int LEN = 10;
        for(int i=0; i<s.length()-LEN; i++){
            String sub = s.substring(i, i+LEN);
            if(!set.contains(sub)){
                int[] counts = count(s, i, i+LEN), oldCount = count(s, i, i+LEN);
                findRepeatedDnaSequences(s, sub, count(s, i, i+LEN), oldCount, set, i+1, LEN);
            }
        }
        List<String> list = new ArrayList<>(set.size());
        list.addAll(set);
        return list;
    }
    private void findRepeatedDnaSequences(String s, String sub, int[] counts, int[] oldCount,Set<String> set, int from, int length){
        if(from+length>s.length()) return;
        int[] tmp = new int[4];
        boolean flag = false;

        //移动字符串时也改变了oldCount
        incOrDecCount(oldCount, s.charAt(from-1), false);
        incOrDecCount(oldCount, s.charAt(from+length-1), true);

        //利用统计减少字符比较次数
        for(int i=0; i<counts.length; i++)
            if(counts[i]!=oldCount[i])
                flag = true;

        if(!flag && s.substring(from, from+length).equals(sub)){
            set.add(sub);
            return;
        }
        findRepeatedDnaSequences(s, sub, counts,  oldCount, set, from+1, length);
    }

    private void incOrDecCount(int[] count, char c, boolean inc){
        int i = inc?1:-1;
        switch (c){
            case 'A': count[0]+=i; break;
            case 'C': count[1]+=i; break;
            case 'G': count[2]+=i; break;
            case 'T': count[3]+=i; break;
            default: break;
        }
    }

    /**
     * 统计ACGT的个数
     * @param s
     * @param from
     * @param to
     * @return
     */
    private int[] count(String s, int from, int to){
        int[] count = new int[4];
        for (int i=from; i<to; i++){
            switch (s.charAt(i)){
                case 'A': count[0]++; break;
                case 'C': count[1]++; break;
                case 'G': count[2]++; break;
                case 'T': count[3]++; break;
                default: break;
            }
        }
        return count;
    }

// time limit exceeded
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> set = new HashSet<>();
        final int LEN = 10;
        for(int i=0; i<s.length()-LEN; i++){
            String sub = s.substring(i, i+LEN);
            if(!set.contains(sub)){
                findRepeatedDnaSequences1(s, sub, set, i+1, LEN);
            }
        }
        List<String> list = new ArrayList<>(set.size());
        list.addAll(set);
        return list;
    }
    private void findRepeatedDnaSequences1(String s, String sub, Set<String> set, int from, int length){
        if(from+length>s.length()) return;
        if(s.substring(from, from+length).equals(sub)){
            set.add(sub);
            return;
        }
        findRepeatedDnaSequences1(s, sub, set, from+1, length);
    }
}
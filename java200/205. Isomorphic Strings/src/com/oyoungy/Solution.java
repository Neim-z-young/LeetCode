package com.oyoungy;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) return false;
        if(s.equals(t)) return true;
        HashMap<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            Character c = s.charAt(i), m = t.charAt(i);
            if(map1.containsKey(c) && map1.get(c)!=m || map2.containsKey(m) && map2.get(m)!=c)
                return false;
            map1.put(c, m);
            map2.put(m, c);
        }
        return true;
    }

    /**
     * faster using index hash
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) return false;
        if(s.equals(t)) return true;
        int[] map1 = new int[256], map2 = new int[256];
        for (int i=0; i<map1.length; i++){
            map1[i] = -1;
            map2[i] = -1;
        }
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i), m = t.charAt(i);
            if(map1[c]==-1 && map2[m]==-1){
                map1[c] = m;
                map2[m] = c;
            }else if(map1[c]!=m || map2[m]!=c)
                return false;
        }
        return true;
    }
}
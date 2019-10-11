package com.oyoungy;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        String ss[] = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(ans.ladderLength("hit", "cog", Arrays.asList(ss)));
    }
    HashMap<String, Boolean> visited;
    HashMap<String, List<String>> adjacency;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        visited = new HashMap<>();
        for(String s:wordList){
            visited.put(s, false);
        }
        visited.put(beginWord, true);
        if(visited.get(endWord)==null) return 0;
        adjacency = new HashMap<>();
        for(String s:wordList){
            generate(s, adjacency);
        }
        generate(beginWord, adjacency);
        return bfs(beginWord, endWord, adjacency, wordList.size());
    }
    private void generate(String s, HashMap<String, List<String>> adjacency){
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            chars[i] = '*';
            String tempS = new String(chars);
            chars[i] = c;
            List<String> adjacent = adjacency.get(tempS);
            if(adjacent==null){
                adjacent = new LinkedList<String>();
                adjacency.put(tempS, adjacent);
            }
            adjacent.add(s);
        }
    }

    //bfs相比于dfs能更快的找到最短路径
    private int bfs(String beginWord, String endWord, HashMap<String, List<String >> adjacency, int maxLevel){
        Queue<String> queue = new LinkedList();
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-->0){
                String ss = queue.poll();
                if(ss.equals(endWord)) return level+1;
                char[] chars = ss.toCharArray();
                for(int i=0; i<chars.length; i++){
                    char c = chars[i];
                    chars[i] = '*';
                    String tempS = new String(chars);
                    chars[i] = c;
                    List<String> adjacent = adjacency.get(tempS);
                    for(String s:adjacent){
                        if(!visited.containsKey(s)){
                            visited.put(s, true);
                            queue.add(s);
                        }
                    }
                }
            }
            if(level++>=maxLevel){
                break;
            }
        }
        return 0;
    }

    //用dfs进行全面搜索，能保证找到路径，但找最短路径比较耗时
    private int dfs(String beginWord, String endWord, HashMap<String, List<String >> adjacency, HashMap<String, Boolean> visited, int depth){
        if(beginWord.equals(endWord)) return depth;
        char[] chars = beginWord.toCharArray();
        int ans = 0;
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            chars[i] = '*';
            String tempS = new String(chars);
            chars[i] = c;
            List<String> adjacent = adjacency.get(tempS);
            for(String s:adjacent){
                if(!visited.get(s)){
                   visited.put(s, true);

                   int temp = dfs(s, endWord, adjacency, visited, depth+1);
                   if(ans==0){
                       ans = temp;
                   }else if(temp!=0){
                       ans = Math.min(ans, temp);
                   }
                   visited.put(s, false);
                }
            }
        }
        return ans;
    }
}
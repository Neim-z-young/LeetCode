package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
}
//TODO 使用char数组优化
class Trie {

    //a-z
    private Trie[] nexts;

    boolean isWord;

    /** Initialize your data structure here. */
    public Trie() {
        nexts = new Trie[26];
        isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.equals("")){
            isWord = true;
            return;
        };
        String sub = word.substring(1);
        char t = word.charAt(0);
        int index = t-'a';
        if(nexts[index]==null){
            nexts[index] = new Trie();
        }
        nexts[index].insert(sub);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.equals("")) return isWord;
        int index = word.charAt(0) - 'a';
        if(nexts[index]==null){
            return false;
        }
        return nexts[index].search(word.substring(1));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.equals("")) return true;
        int index = prefix.charAt(0) - 'a';
        if(nexts[index]==null){
            return false;
        }
        return nexts[index].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
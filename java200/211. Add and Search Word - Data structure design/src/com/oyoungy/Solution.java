package com.oyoungy;

import java.util.zip.InflaterInputStream;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
}
class WordDictionary {

    WordSearchTree tree;
    /** Initialize your data structure here. */
    public WordDictionary() {
        tree = new WordSearchTree();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        tree.addWord(word.toCharArray(), 0);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return tree.searchWord(word.toCharArray(), 0);
    }
}

//using Trie
class WordSearchTree{
    private WordSearchTree[] tree;
    boolean isWord;

    public WordSearchTree(){
        tree = new WordSearchTree[26];
        isWord = false;
    }

    public void addWord(char[] word, int index){
        if(index>=word.length){
            isWord = true;
            return;
        }
        int i = word[index] - 'a';
        if(tree[i]==null){
            tree[i] = new WordSearchTree();
        }
        tree[i].addWord(word, index+1);
    }

    public boolean searchWord(char[] word, int index){
        if(index == word.length){
            return isWord;
        }
        char tmp = word[index];
        if(tmp == '.'){
            return searchWordGeneral(word, index);
        }else {
            int i = tmp - 'a';
            if(tree[i]==null)
                return false;
            return tree[i].searchWord(word, index+1);
        }
    }
    private boolean searchWordGeneral(char[] word, int index){
        boolean contains = false;
        for(int i=0; i<tree.length && !contains; i++){
            if(tree[i]!=null){
                contains = tree[i].searchWord(word, index + 1);
            }
        }
        return contains;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
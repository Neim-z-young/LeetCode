package com.oyoungy;

import java.util.*;

public class Solution {

    class LRUCache {

        Map<Integer, Integer> map;
        LinkedList<Integer> keyQueue;
        int size;

        public LRUCache(int capacity) {
            this.size = capacity;
            keyQueue = new LinkedList<Integer>();
            map = new HashMap<>();
        }

        public int get(int key) {
            Integer value = map.get(key);
            if(value!=null){
                keyQueue.remove((Object) new Integer(key));
                keyQueue.offer(key);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                keyQueue.remove((Object) new Integer(key));
            }else {
                while (map.size()>=size){
                    Integer temp = keyQueue.poll();
                    map.remove(temp);
                }
            }
            map.put(key, value);
            keyQueue.offer(key);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
        LRUCache lruCache = new Solution().new LRUCache(2);
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
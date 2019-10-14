package com.oyoungy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    private HashMap<Integer, Node> isVisited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node newNode = isVisited.get(node.val);
        if(newNode!=null) return newNode;
        List<Node> newNeighbors = new ArrayList<>(node.neighbors.size());
        newNode = new Node(node.val, newNeighbors);
        isVisited.put(newNode.val, newNode);
        for(int i=0; i<node.neighbors.size(); i++){
            newNeighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return newNode;
    }
}
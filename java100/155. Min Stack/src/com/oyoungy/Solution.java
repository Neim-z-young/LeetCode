package com.oyoungy;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    class MinStack {
        Stack<Integer> stack, minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int x) {
            if(stack.size()==0 || x<=minStack.peek())
                minStack.push(x);
            stack.push(x);
        }

        public void pop() {
            if(stack.size()==0)
                throw new RuntimeException("empty stack");
            int tmp = stack.pop();
            if(tmp==minStack.peek())
                minStack.pop();
        }

        public int top() {
            if(stack.size()==0)
                throw new RuntimeException("empty stack");
            return stack.peek();
        }

        public int getMin() {
            if(stack.size()==0)
                throw new RuntimeException("empty stack");
            return minStack.peek();
        }
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
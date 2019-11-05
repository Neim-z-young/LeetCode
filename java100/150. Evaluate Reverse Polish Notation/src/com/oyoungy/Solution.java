package com.oyoungy;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(2/3);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                numStack.push(numStack.pop() + numStack.pop());
            } else if (token.equals("-")) {
                int op2 = numStack.pop(), op1 = numStack.pop();
                numStack.push(op1 - op2);
            } else if (token.equals("*")) {
                numStack.push(numStack.pop() * numStack.pop());
            } else if (token.equals("/")) {
                int op2 = numStack.pop(), op1 = numStack.pop();
                numStack.push(op1 / op2);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }
}
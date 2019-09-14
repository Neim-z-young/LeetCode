package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.simplifyPath("/../"));
        System.out.println(ans.simplifyPath("/a/../../b/../c//.//"));
    }
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        StringBuilder str  = new StringBuilder();
        int index = -1;
        for(int i=0; i<strings.length; i++){
            if(strings[i].equals(".") || strings[i].equals("")){

            }else if(strings[i].equals("..")){
                if(--index<0){
                    index = -1;
                }
            }else {
                strings[++index] = strings[i];
            }
        }
        for (int i=0; i<=index; i++){
            str.append("/"+strings[i]);
        }
        if(index<0){
            str.append("/");
        }
        return str.toString();
    }
}
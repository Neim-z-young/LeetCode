package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.candy(new int[]{1,3,4,5,2}));
    }
    public int candy(int[] ratings) {
        int assign[] = new int[ratings.length];
        for(int i=0; i<assign.length; i++){
            assign[i] = 1;
        }
        for(int i=0; i<ratings.length;){
            //expand
            int index = nextMin(ratings, i);
            for(int j=index-1; j>=i; j--){
                assign[j] = Math.max(assign[j], assign[j+1]+1);
            }
            while (index+1<ratings.length && ratings[index]<ratings[index+1]){
                index++;
                assign[index] = assign[index-1]+1;
            }
            i = i==index?i+1:index;
        }
        int ans = 0;
        for(int i=0; i<ratings.length; i++){
            ans+=assign[i];
        }
        return ans;
    }
    private int nextMin(int[] ratings, int i){
        while (i+1<ratings.length && ratings[i]>ratings[i+1]){
            i++;
        }
        return i;
    }
}
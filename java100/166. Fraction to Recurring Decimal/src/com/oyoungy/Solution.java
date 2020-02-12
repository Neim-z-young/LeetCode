package com.oyoungy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.fractionToDecimal(1, 6));
        System.out.println(ans.fractionToDecimal(1, 3));
        System.out.println(ans.fractionToDecimal(1, 5));
        System.out.println(ans.fractionToDecimal(1, -5));
        System.out.println(ans.fractionToDecimal(4, 333));
        System.out.println(ans.fractionToDecimal(0, -333));
        System.out.println(ans.fractionToDecimal(1, 214748364));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long numer = numerator, deno = denominator;
        numer = Math.abs(numer);
        deno = Math.abs(deno);
        long remain = numer%deno, div = numer/deno;
        StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
        if(numerator!=0 && numerator<0^denominator<0)
            sb.append('-');
        sb.append(div);

        HashMap<Long, Integer> pos = new HashMap<>(); //decode remain pos
        List<Long> list = new ArrayList<>(); //recode value list
        int count = 0;
        boolean flag = false;

        while (remain!=0){
            pos.put(remain, count++);

            remain*=10;
            while (remain<deno){
                pos.put(remain, count++);
                list.add((long)0);
                remain*=10;
            }
            div = remain/deno;
            list.add(div);

            remain = remain%deno;

            if(pos.containsKey(remain)){
                flag = true;  //means infinite fraction
                break;
            }
        }

        if(flag){
            int p = pos.get(remain);
            sb.append('.');
            for(int i=0 ;i<p; i++)
                sb.append(list.get(i));
            sb.append('(');
            for (int i=p; i<list.size(); i++){
                sb.append(list.get(i));
            }
            sb.append(')');
        }
        else if(list.size()>0){
            sb.append('.');
            for (int i=0; i<list.size(); i++)
                sb.append(list.get(i));
        }
        return sb.toString();
    }
}
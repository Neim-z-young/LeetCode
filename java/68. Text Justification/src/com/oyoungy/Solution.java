package com.oyoungy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        List<String> ans = new ArrayList<>();
        while (index<words.length){
            int len = words[index].length(), i=index+1;
            int spaces = 1;
            while (i<words.length && len+words[i].length()<maxWidth){
                len= len + spaces+ words[i].length();
                i++;
            }
            StringBuilder temp = new StringBuilder();
            if(i==words.length){  //最后一行
                while (index<i){
                    temp.append(words[index]);
                    if (temp.length()<maxWidth){
                        temp.append(" ");
                    }
                    index++;
                }
            }else {  //首行及中间行
                int num = i - index, addSpaces = maxWidth - len;
                int spaceNum = 0, remainSpa = 0;
                if (num != 1) {
                    spaceNum = addSpaces / (num - 1);   //每两个单词之间需填补的空格数
                    remainSpa = addSpaces % (num - 1);  //填充空格使得字符串长度符合要求
                }
                StringBuilder spaceStr = new StringBuilder();
                //两个单词之间至少一个空格
                spaceStr.append(" ");
                for (int j = 0; j < spaceNum; j++) {
                    spaceStr.append(" ");
                }
                while (index < i) {
                    temp.append(words[index]);
                    if (index != i - 1) {
                        temp.append(spaceStr);
                        if (remainSpa-- > 0) {
                            temp.append(" ");
                        }
                    }
                    index++;
                }
            }
            //长度不够则向尾部添空格
            while (temp.length()<maxWidth){
                temp.append(" ");
            }
            ans.add(temp.toString());
        }
        return ans;
    }
}
package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        for(int i=1; i<=120; i++){
            System.out.println(ans.getPermutation(5, i));
        }
    }
    public String getPermutation(int n, int k) {
        int[] flag = new int[n+1];
        return getPermutation(flag, n, k);
    }

    //找规律使用递归法
    public String getPermutation(int[] flag, int n, int k) {
        if(k==0) return "";
        int valve = 1, index = 1;
        //根据k值确定已知的前缀位数
        for(index = 1; index<=n; index++){
            if((valve*=index)>=k){
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
//        for(int i =index+1; i<=n; i++){
//            int kthMin = findMin(flag,1);
//            if(kthMin!=0){
//                flag[kthMin] = 1;
//                ans.append(kthMin);
//            }
//        }
        //faster method
        int temp = index+1;
        for(int i=1; i<flag.length; i++){
            if(flag[i]==0 && temp++<=n){
                ans.append(i);
                flag[i] = 1;
            }
        }

        if(valve==k){   //阈值为k时，表明剩余数字逆序排列
//            for(int i=0; i<k; i++){
//                int kthMax = findMax(flag, 1);
//                if(kthMax!=0){
//                    flag[kthMax] = 1;
//                    ans.append(kthMax);
//                }
//            }
            //faster method
            for(int i=flag.length-1; i>=1; i--){
                if(flag[i]==0 && valve-->0){
                    ans.append(i);
                    flag[i] = 1;
                }
            }
        }else {    //递归方式求解后序序列
            int times = (k-1)/(valve/index);  //when k==6 and valve/index ==6, then times should be 0
            int kthMin = findMin(flag, times+1);
            if(kthMin!=0){
                flag[kthMin] = 1;
                ans.append(kthMin);
            }
            ans.append(getPermutation(flag, n-ans.length(), k-(times)*(valve/index)));
        }
        return ans.toString();
    }
    private int findMin(int[] flag, int kth){
        for(int i=1; i<flag.length; i++){
            if(flag[i]==0 && 1>(--kth)) {
                return i;
            }
        }
        return 0;
    }
    private int findMax(int[] flag, int kth){
        for(int i=flag.length-1; i>0; i--){
            if(flag[i]==0 && 1>(--kth)) {
                return i;
            }
        }
        return 0;
    }
}
#include<iostream>
using namespace std;
//全是加法，竟然超时了
class Solution {
public:
    int divide(int dividend, int divisor) {
        if(dividend==INT32_MIN&&divisor==-1) return INT32_MAX;
        if(divisor==0) return -1;
        if(divisor==-1) return -dividend;
        if(divisor==1) return dividend;
        int divide = 0;
        bool flag = false;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)) flag = true;
        if(dividend==INT32_MIN){
            if(flag) {
                divide=1;
                dividend=dividend-divisor;
            }else {
                divide=-1;
                dividend=dividend+divisor;
            }
        }
        //题目中，被除数大于0则余数应大于等于0，否则余数应小于等于0
        while(1){
            // c=a/b
            //a>0 b>0
            if(flag&&(dividend-divisor)>=0&&(dividend)>(dividend-divisor)){
                dividend-=divisor;
                divide++;
            }//a<0 b<0
            else if(flag&&(dividend-divisor)<=0&&(dividend)<(dividend-divisor)){
                dividend-=divisor;
                divide++;
            }//a>0 b<0
            else if(!flag&&(dividend+divisor)>=0&&(dividend)>(dividend+divisor)){
                dividend+=divisor;
                divide--;
            }//a<0 b>0
            else if(!flag&&(dividend+divisor)<=0&&(dividend)<(dividend+divisor)){
                dividend+=divisor;
                divide--;
            }else break;
        }
        return divide;
    }
private:
    int myABS(int num){
        if(num==INT32_MIN) return INT32_MAX;
        if(num<0) num*=-1;
        return num;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}

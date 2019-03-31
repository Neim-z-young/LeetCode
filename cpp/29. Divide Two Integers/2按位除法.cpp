#include<iostream>
using namespace std;
//全是加法，竟然超时了
class Solution {
public:
    int divide(int dividend, int divisor) {
        //保证被除数最小时有意义
        if(dividend==INT32_MIN&&divisor==-1) return INT32_MAX;
        if(dividend==INT32_MIN&&divisor==1) return INT32_MIN;
        //除数最小时，防止溢出
        if(divisor==INT32_MIN&&dividend==INT32_MIN) return 1;
        if(divisor==INT32_MIN) return 0;
        if(divisor==0) return -1;
        int divide = 0;
        int flag = -1;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)) flag = 1;
        //保证被除数最小时运算不溢出
        if(dividend==INT32_MIN){
            if(flag==1) {
                dividend=dividend-divisor;
            }else {
                dividend=dividend+divisor;
            }
            divide=1;
        }
        dividend = abs(dividend);
        divisor = abs(divisor);
        //位运算，O(logn)，效率高
        while(dividend>=divisor){
            int temp = divisor, i=1;
            while(temp>=0&&dividend>=temp){
                dividend-=temp;
                divide+=i;
                i=i<<1;
                temp=temp<<1;
            }
        }
        return divide*flag;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.divide(10, 3);
    return 0;
}

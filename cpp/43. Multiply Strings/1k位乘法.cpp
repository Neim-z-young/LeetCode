#include<iostream>
#include<string>
#include<sstream>
#include<time.h>
using namespace std;
class Solution {
public:
    string multiply(string num1, string num2) {
        return doKMultiply(num1, num2, 4);
    }
private:
    //最大做4位乘法
    string doKMultiply(string num1, string num2, int k){
        int size1 = num1.size(), size2 = num2.size();
        string ans="0";
        for(int inx1 = k; inx1<=size1+k; inx1+=k){
            unsigned int tmp1=0;
            //判断位数是否够k位
            if(size1>=inx1){
                tmp1 = atoi(num1.substr(size1-inx1, k).c_str());
            }else if(inx1-size1>0&&inx1-size1<k){
                tmp1 = atoi(num1.substr(0, k-(inx1-size1)).c_str());
            }
            for(int inx2 = k; inx2<=size2+k; inx2+=k){
                unsigned int tmp2 = 0;
                if(size2>=inx2){
                    tmp2 = atoi(num2.substr(size2-inx2, k).c_str());
                }else if(inx2-size2>0&&inx2-size2<k){
                    tmp2 = atoi(num2.substr(0, k-(inx2-size2)).c_str());
                }
                unsigned int times = tmp1*tmp2;
                stringstream ss;
                ss<<times;
                string tmpS = ss.str();
                if(times!=0){
                    for(int i=k; i<inx1; i++){
                        tmpS+="0";
                    }
                    for(int j=k; j<inx2; j++){
                        tmpS+="0";
                    }
                }
                ans = doKAdd(ans, tmpS, 9);
                ans;
            }
        }
        return ans;
    }
    //最大做9位加法，才能保证不溢出
    string doKAdd(string num1, string num2, int k){
        int size1 = num1.size(), size2 = num2.size();
        //去除开头的0
        int zInx = 0;
        for(; zInx<size1; zInx++){
            if(zInx==size1-1||num1[zInx]!='0')
                break;
        }
        num1 = num1.substr(zInx, size1-zInx);
        zInx=0;
        for(; zInx<size2; zInx++){
            if(zInx==size2-1||num2[zInx]!='0')
                break;
        }
        num2 = num2.substr(zInx, size2-zInx);
        size1 = num1.size();
        size2 = num2.size();
        //取k的整数倍
        int max = (size1>size2?size1:size2)+k;
        int inx = k, carry = 0;
        string ans="";
        int base=1;
        for(int j=0; j<k; j++) base*=10;
        for(; inx<=max; inx+=k){
            unsigned int tmp1=0, tmp2=0;
            //判断位数是否够k位
            if(size1>=inx){
                tmp1 = atoi(num1.substr(size1-inx, k).c_str());
            }else if(inx-size1>0&&inx-size1<k){
                tmp1 = atoi(num1.substr(0, k-(inx-size1)).c_str());
            }
            if(size2>=inx){
                tmp2 = atoi(num2.substr(size2-inx, k).c_str());
            }else if(inx-size2>0&&inx-size2<k){
                tmp2 = atoi(num2.substr(0, k-(inx-size2)).c_str());
            }
            tmp1 = tmp1 + tmp2 + carry;
            carry = tmp1/base;
            tmp1 = tmp1%base;
            stringstream ss;
            ss<<tmp1;
            string tmpS = ss.str();
            //有进位或非首部且位数不够k位则补零
            if(carry==1||inx+k<max){
                for(int j=tmpS.size(); j<k; j++){
                    tmpS = "0"+tmpS;
                }
            }else if(tmpS=="0"&&ans!="") tmpS = "";
            ans = tmpS+ans;
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.multiply("123001", "7000")<<endl;
    cout<<ans.multiply("81001", "29000")<<endl;
    cout<<ans.multiply("101000", "229000")<<endl;
    cout<<ans.multiply("101000", "00000")<<endl;
    cout<<ans.multiply("0000", "0")<<endl;
    cout<<ans.multiply("779405635269", "298224000000")<<endl;
    cout<<ans.multiply("930047927929", "7607999646288178")<<endl;
    //"7075804306714884864908723362"
    //        **
    cout<<ans.multiply("123456789", "987654321")<<endl;
    //"121932631112635269"
    //      **
    clock_t start, finish;
    double deltatime;
    start = clock();
    for(int i=0; i<100; i++){
        ans.multiply("123127482938562783487234234528348512312312728687863785", "26426421231231233123423423457624384162374182378416234823648723423");
    }
    finish = clock();
    deltatime = (finish-start)/CLOCKS_PER_SEC;
    cout<<deltatime/100;
    return 0;
}

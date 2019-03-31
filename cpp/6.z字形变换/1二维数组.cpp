#include<string>
#include<iostream>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;
        int len = s.length();
        char *A = new char[numRows*len+1];
        A[numRows*len]=0;
        for(int i=0;i<numRows*len;++i){
            A[i]=' ';
        }
        int index = 0;
        int i = 0;
        int j = 0;
        bool flag = false;
        while(index<len){
           int residual = index % (numRows-1);
            A[i*len+j] = s[index];
            index++;
           if(!flag){    
                i++;
                if (residual==numRows-2){
                    flag = true;
                }
            }
            else{
                j++;
                i--;
                if (residual==numRows-2){
                    flag = false;
                }
            }
        }
        char *B = new char[len+1];
        B[len] = '\0';
        j=0;
        for(int i=0;i<numRows*len;i++){
            if(A[i]!=0){
                B[j] = A[i];
                j++;
            }
        }
        return string(B);
    }
};

int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.convert("PAYPALISHIRING", 3);
    return 0;
}

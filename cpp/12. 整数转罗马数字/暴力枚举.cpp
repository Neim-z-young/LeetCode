#include<iostream>
#include<string>
using namespace std;
string I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
string X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
string C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
string M[] = {"", "M", "MM", "MMM"};
class Solution {
public:
    string intToRoman(int num) {
        return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[num%10];
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.intToRoman(1234);
    return 0;
}

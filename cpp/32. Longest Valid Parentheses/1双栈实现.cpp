#include<string>
#include<iostream>
#include<stack>
using namespace std;
//括号有两种有效排列方式 1.相邻   2.包含
//故需考虑括号之间的合并方式,能进行迭代
//故可采用栈进行判断
//复杂度  time O(n)  space O(n)
struct pos {
    int head;
    int tail;
};
class Solution {
public:
    int longestValidParentheses(string s) {
        int size = s.size();
        //两个栈，括号栈与有效子括号栈
        stack<int> mystack;
        stack<pos> posStack;
        //找出所有有效的最长括号，并将其首尾下标对入栈
        for(int i=0; i<size; i++){
            if(s[i]=='(') mystack.push(i);
            else{
                if(mystack.empty()) {
                    continue;
                }
                else{
                    pos tmp;
                    tmp.head = mystack.top();
                    tmp.tail = i;
                    mystack.pop();
                    while(!posStack.empty()){
                        //从栈中取出一对括号
                        pos parent = posStack.top();
                        posStack.pop();
                        //相邻
                        if(parent.tail == tmp.head-1){
                            parent.tail = tmp.tail;
                            posStack.push(parent);
                            break;
                        }
                        //包含或相等
                        else if(parent.head==(tmp.head+1)&&parent.tail==(tmp.tail-1)){
                            continue;
                        }
                        //添加新括号对
                        else{
                            posStack.push(parent);
                            posStack.push(tmp);
                            break;
                        }
                    }
                    if(posStack.empty()) posStack.push(tmp);
                }
            }
        }
        //找最长的有效括号
        int maxLen = 0;
        while(!posStack.empty()){
            pos tmp = posStack.top();
            posStack.pop();
            if(tmp.tail-tmp.head+1>maxLen) maxLen = tmp.tail-tmp.head+1;
        }
        return maxLen;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    cout<<ans.longestValidParentheses("()(())");
    return 0;
}

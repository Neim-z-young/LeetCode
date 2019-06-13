#include<iostream>
#include<vector>
using namespace std;
struct myhash{
private:
    bool index[10] = {0};
public:
    bool insertChar(char inx){
        if(inx=='.') return true;
        if(index[inx-'0']) return false;
        index[inx-'0'] = true;
        return true;
    }
};
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int row = 9, col = 9;
        //行判断
        for(int i=0; i<row; i++){
            myhash tmp;
            for(int j=0; j<col; j++){
                if(!tmp.insertChar(board[i][j])) return false;
            }
        }
        //列判断
        for(int i=0; i<col; i++){
            myhash tmp;
            for(int j=0; j<row; j++){
                if(!tmp.insertChar(board[j][i])) return false;
            }
        }
        //格子判断
        for(int k=0; k<row; k+=3){
            for(int h=0; h<col; h+=3){
                myhash tmp;
                for(int i=k; i<k+3; i++){
                    for(int j=h; j<h+3; j++){
                        if(!tmp.insertChar(board[i][j])) return false;
                    }
                }
            }
        }
        return true;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}

#include<iostream>
#include<vector>
using namespace std;
//O(n) is too big，
//pass time is 2188ms
//memory is 426.8MB
//It's unacceptable
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
    void solveSudoku(vector<vector<char>>& board) {
        board = backTrackSolve(board);
    }
private:
    vector<vector<char>> backTrackSolve(vector<vector<char>> board){
        vector<vector<char>> ans = board;
        int row = 9, col = 9;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ans[i][j]=='.'){
                    for(int k=1; k<10; k++){
                        ans[i][j] = k+'0';
                        if(isValidSudoku(ans, i, j)){
                            ans = backTrackSolve(ans);
                            //已完成则退出
                            if(isFinishedSudoku(ans))
                                return ans;
                        }
                        //无效则重置
                        ans = board;
                        if(k==9) return ans;
                    }
                }
            }
        }
        return ans;
    }
    //判断是否完成
    bool isFinishedSudoku(vector<vector<char>> board) {
        int row = 9, col = 9;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='.')
                    return false;
            }
        }
        return true;
    }
    //只判断加进去的值在其所在的行列及格子中是否有效
    bool isValidSudoku(vector<vector<char>> board, int rowi, int colj) {
        int row = 9, col = 9;
        //行判断
        myhash tmp1;
        for(int j=0; j<col; j++){
            if(!tmp1.insertChar(board[rowi][j])) return false;
        }
        //列判断
        myhash tmp2;
        for(int i=0; i<row; i++){
            if(!tmp2.insertChar(board[i][colj])) return false;
        }
        //格子判断
        myhash tmp3;
        int k=(rowi/3)*3, h=(colj/3)*3;
        for(int i=k; i<k+3; i++){
            for(int j=h; j<h+3; j++){
                if(!tmp3.insertChar(board[i][j])) return false;
            }
        }
        return true;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    vector<vector<char>> sudoku({
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    });
    ans.solveSudoku(sudoku);
    return 0;
}

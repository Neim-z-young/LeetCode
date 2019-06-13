#include<iostream>
#include<vector>
using namespace std;
//O(n) is too big，
//pass time is 2188ms
//memory is 426.8MB
//It's unacceptable
class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        backTrackSolve(board);
    }
private:
    int n = 9;
    bool next(int &r, int &c, vector<vector<char>> board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.'){
                    r=i;
                    c=j;
                    return true;
                }
            }
        }
        return false;
    }
    bool backTrackSolve(vector<vector<char>>& board){
        int i, j;
        if(!next(i, j, board)) return true;
        if(board[i][j]=='.'){
            for(int k=1; k<10; k++){
                if(isValidSudoku(board, i, j, k+'0')){
                    board[i][j] = k+'0';
                    if(backTrackSolve(board))
                        return true;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    //只判断加进去的值在其所在的行列及格子中是否有效
    bool isValidSudoku(vector<vector<char>> board, int rowi, int colj, char val) {
        int row = 9, col = 9;
        //行判断
        for(int j=0; j<col; j++){
            if(board[rowi][j]==val) return false;
        }
        //列判断
        for(int i=0; i<row; i++){
            if(board[i][colj]==val) return false;
        }
        //格子判断
        int k=(rowi/3)*3, h=(colj/3)*3;
        for(int i=k; i<k+3; i++){
            for(int j=h; j<h+3; j++){
                if(board[i][j]==val) return false;
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

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3


solution::

class Solution {
public:
    bool dfs(vector<vector<char>>&board, int i, int j, string word, int count) {
        if(word.length() == count) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.size() || j >= board[i].size() || board[i][j] != word[count]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        bool flag = dfs(board, i+1, j, word, count+1)||
                    dfs(board, i-1, j, word, count+1)||
                    dfs(board, i, j+1, word, count+1)||
                    dfs(board, i, j-1, word, count+1);
        board[i][j] = temp;
        return flag;
        }
    bool exist(vector<vector<char>>& board, string word) {
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[i].size(); j++) {
                if(board[i][j] == word[0] && dfs(board,i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
};

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    boolean backtrack(char[][] board) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == '.') {
                    for(char value = '1'; value <= '9'; value++) {
                        // char c = (char)(value + '0');
                        if(isSafe(board, i, j, value)) {
                            board[i][j] = value;
                            if(backtrack(board)) return true;
                            else board[i][j] = '.';
                        } 
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSafe(char[][] board, int row, int col, char value) {
        for(int i = 0; i < 9; i ++) {
            if(board[row][i] == value) return false;
            if(board[i][col] == value) return false;
            if(board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == value) return false;
        }
        return true;
    }
}
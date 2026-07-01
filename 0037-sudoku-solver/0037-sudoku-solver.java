class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    //TC: O(9^E), where E = number of empty cells
    // Worst case: O(9^81)

    // SC: O(E)
    // Worst case: O(81)

    boolean backtrack(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isSafe(board, i, j, c)) {
                            board[i][j] = c;

                            if (backtrack(board))
                                return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSafe(char[][] board, int row, int col, char c) { //O(9)
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c)
                return false;
        }
        return true;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        //SC: O(1) (max 243 entries in set) -> 81 + 81 + 81 : 9 rows × 9 digits = 81
        // 9 columns × 9 digits = 81
        // 9 boxes × 9 digits = 81
        // Total possible entries = 81 + 81 + 81 = 243
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.')
                    if (!set.add(board[i][j] + " in row " + i) || !set.add(board[i][j] + " in col " + j)
                            || !set.add(board[i][j] + " in row " + i / 3 + " and col " + j / 3))
                        return false;
            }
        }
        return true;
    }

}
class Solution {
    void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] == '0')
            return;

        vis[row][col] = true;

        int[] dRow = { -1, 0, 1, 0 };
        int[] dCol = { 0, -1, 0, 1 };

        for (int k = 0; k < 4; k++) {
            int r = row + dRow[k];
            int c = col + dCol[k];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !vis[r][c] && grid[r][c] == '1')
                dfs(r, c, grid, vis);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
}
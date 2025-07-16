class Solution {
    class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            adj.add(row);
        }

        
        queue.offer(new Pair(0, 0));
        visited[0][0] = true;
        int ct = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int r = queue.peek().row;
                int c = queue.peek().col;
                queue.poll();
                
                if (r == n - 1 && c == n - 1)
                    return ct;

                for (int dRow = -1; dRow <= 1; dRow++) {
                    for (int dCol = -1; dCol <= 1; dCol++) {
                        int nRow = r + dRow;
                        int nCol = c + dCol;

                        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n
                                && grid[nRow][nCol] == 0 && !visited[nRow][nCol]) {
                            visited[nRow][nCol] = true;
                            queue.offer(new Pair(nRow, nCol));
                        }
                    }
                }
            }
            ct++;
        }

        return -1;
    }
}
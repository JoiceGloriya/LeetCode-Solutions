class Solution {
    class Pair {
        int row, col, steps;

        public Pair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;
        
        queue.offer(new Pair(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int r = queue.peek().row;
                int c = queue.peek().col;
                int steps = queue.peek().steps;
                queue.poll();
                
                if (r == n - 1 && c == n - 1)
                    return steps;

                for (int dRow = -1; dRow <= 1; dRow++) {
                    for (int dCol = -1; dCol <= 1; dCol++) {
                        int nRow = r + dRow;
                        int nCol = c + dCol;

                        if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n
                                && grid[nRow][nCol] == 0 && !visited[nRow][nCol]) {
                            visited[nRow][nCol] = true;
                            queue.offer(new Pair(nRow, nCol, steps+ 1));
                        }
                    }
                }
            }
          
        }

        return -1;
    }
}
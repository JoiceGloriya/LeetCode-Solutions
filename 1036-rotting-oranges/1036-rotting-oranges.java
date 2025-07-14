class Solution {
    class Tuple {
        private int row, col, time;

        public Tuple(int a, int b, int c) {
            row = a;
            col = b;
            time = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int countFresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<Tuple> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 2;
                    queue.offer(new Tuple(i, j, 0));
                } 
                else if (grid[i][j] == 1)
                    countFresh++;
            }
        }
        if (countFresh == 0)
            return 0;

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        int maxTime = 0, ct = 0;

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            maxTime = Math.max(maxTime, time);
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = row + drow[i];
                int nCol = col + dcol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                        && grid[nRow][nCol] == 1 && visited[nRow][nCol] != 2) {
                    visited[nRow][nCol] = 2;
                    queue.offer(new Tuple(nRow, nCol, time + 1));
                    ct++;
                }
            }

        }
        if (ct != countFresh) //u havent rotten ALL fresh oranges :(
            return -1;
        return maxTime;
    }
}
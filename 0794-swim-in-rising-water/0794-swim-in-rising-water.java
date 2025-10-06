class Solution {

    class Tuple {
        private int row, col, time;

        public Tuple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        visited[0][0] = true;
        pq.offer(new Tuple(0, 0, grid[0][0]));
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int row = tuple.row;
            int col = tuple.col;
            int time = tuple.time;

            if (row == n - 1 && col == n - 1)
                return time;

            for (int[] d : dir) {
                int nRow = row + d[0];
                int nCol = col + d[1];

                if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= n)
                    continue;

                if (!visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    int t = Math.max(time, grid[nRow][nCol]);
                    pq.offer(new Tuple(nRow, nCol, t));
                }
            }
        }
        return -1;
    }
}
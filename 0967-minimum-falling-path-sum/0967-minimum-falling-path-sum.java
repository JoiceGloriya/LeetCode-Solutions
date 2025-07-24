// class Solution {
//     int func(int row, int col, int n, int[][] matrix, int[][] dp) {
//         if (col > n - 1 || col < 0)
//             return Integer.MAX_VALUE;
//         if(row == n - 1 ) 
//             return matrix[row][col];
//         if(dp[row][col] != -1) return dp[row][col];
//         int down = func(row + 1, col, n, matrix, dp);
//         int downLeft = func(row + 1, col - 1, n, matrix, dp);
//         int downRight = func(row + 1, col + 1, n, matrix, dp);
//         return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(downLeft, downRight));
//     }

//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length, ans = Integer.MAX_VALUE;
//         int[][] dp = new int[n][n];
//         for(int[] d: dp)
//             Arrays.fill(d, -1);
//         for (int i = 0; i < n; i++) {
//             int val = func(0, i, n, matrix, dp);
//             ans = Math.min(ans, val);
//         }
//         return ans;
//     }
// }

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, mini = Integer.MAX_VALUE;
        // int[][] dp = new int[n][n];
        int[] prev = new int[n];

        for (int col = 0; col < n; col++) {
            prev[col] = matrix[0][col];
        }
        
        for (int row = 1; row < n; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++) {
                int downLeft = Integer.MAX_VALUE;
                int downRight = Integer.MAX_VALUE;
                int down = prev[col];
                if(col - 1 >= 0)
                 downLeft = prev[col - 1];
                if(col + 1 < n)
                downRight = prev[col + 1];
             temp[col] = matrix[row][col] + Math.min(down, Math.min(downLeft, downRight));
            }
            prev = temp;
        }

        for (int col = 0; col < n; col++) {
            mini = Math.min(mini, prev[col]) ;
        }
return mini;
    }
}
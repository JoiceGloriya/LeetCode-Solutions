// class Solution {

//     int func(int r, int c, int m, int n, int[][] dp) {
//         if (r >= m || c >= n)
//             return 0;

//         if (r == m - 1 && c == n - 1) {
//             return 1;
//         }

//         if(dp[r][c] != -1) return dp[r][c];

//         return dp[r][c] = func(r + 1, c, m, n, dp) + func(r, c + 1, m, n, dp);
//     }

//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int[] d: dp)
//             Arrays.fill(d, -1);
//        return func(0, 0, m, n, dp);
//     }
// }

class Solution {
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];

    //     dp[0][0] = 1;

    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (i > 0)
    //                 dp[i][j] += dp[i - 1][j];
    //             if (j > 0)
    //                 dp[i][j] += dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }
    
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if (i > 0)
                //     dp[i][j] += dp[i - 1][j];
                if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
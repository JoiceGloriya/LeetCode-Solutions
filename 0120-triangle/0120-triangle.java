
// class Solution {
//     int func(int row, int col, int m, List<List<Integer>> triangle, int[][] dp) {
//         if (row >= m)
//             return 0; //last valid row is m - 1
//         if (dp[row][col] != -1)
//             return dp[row][col];
//         int left = func(row + 1, col, m, triangle, dp);
//         int right =  func(row + 1, col + 1, m, triangle, dp) ;
//         return dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);
//     }

//     public int minimumTotal(List<List<Integer>> triangle) {
//         int m = triangle.size();
//         int[][] dp = new int[m][m];
//         for (int[] d : dp)
//             Arrays.fill(d, -1);
//         return func(0, 0, m, triangle, dp);
//     }
// }

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = triangle.size();
        // int[][] dp = new int[n][n];

        // for (int j = 0; j < n; j++)
        //     dp[n - 1][j] = triangle.get(n - 1).get(j);

        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = i; j >= 0; j--) {
        //         int left = dp[i + 1][j];
        //         int right = dp[i + 1][j + 1];
        //         dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
        //     }
        // }
        // return dp[0][0];

        int n = triangle.size();
        int[] prev = new int[n];

        for (int j = 0; j < n; j++)
            prev[j] = triangle.get(n - 1).get(j);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = prev[j];
                int right = prev[j + 1];
                prev[j] = triangle.get(i).get(j) + Math.min(left, right);
            }
           
        }
        return prev[0];
    }
}
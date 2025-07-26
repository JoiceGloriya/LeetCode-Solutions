// class Solution {
//     int func(int i, int j, String s, String t, int[][] dp) {
//         if(j < 0) return 1;
//         if(i < 0) return 0;

//         if(dp[i][j] != -1) return dp[i][j] ;

//         if(s.charAt(i) == t.charAt(j))
//             return dp[i][j]  = func(i - 1, j - 1, s , t, dp) + func(i - 1, j, s, t, dp);
//         else return dp[i][j] = func(i - 1, j, s, t, dp);
//     }
//     public int numDistinct(String s, String t) {
//         int n1 = s.length(), n2 = t.length();
//         int[][] dp = new int[n1][n2];

//         for(int[] d: dp)
//             Arrays.fill(d, -1);
//         return func(n1 - 1, n2 - 1, s, t, dp);
//     }
// }
class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        // int[][] dp = new int[n1 + 1][n2 + 1];

        
        // for (int i = 0; i <= n1; i++)
        //     dp[i][0] = 1;  //since you can achieve a target of 0 [init. config]

        
        int[] prev = new int[n2 + 1];
        
        prev[0] = 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = n2; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                     prev[j] = prev[ j - 1] + prev[ j];
            }
        }

        return prev[n2];
    }
}
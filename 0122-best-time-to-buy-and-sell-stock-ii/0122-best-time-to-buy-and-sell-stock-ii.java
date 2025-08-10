
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length, profit = 0;

//        for(int i = 1; i < n; i ++) {
//                if(prices[i] > prices[i - 1])       //if SP is greater than CP, thn its profit
//                profit += prices[i] - prices[i - 1];
//        }
//         return profit;
//     }
// }

class Solution {
    // int func(int i, int buy, int profit, int[] prices, int[][] dp) {
    //     if(i  == prices.length) return 0;

    //     if(dp[i][buy] != -1) return dp[i][buy];

    //     if(buy == 1) {
    //         profit += Math.max(
    //             -prices[i] + func(i + 1, 0, profit, prices, dp), 
    //             0 + func(i + 1, 1, profit, prices, dp)
    //         );
    //     }

    //     else {
    //          profit += Math.max(
    //             prices[i] + func(i + 1, 1, profit, prices, dp), 
    //             0 + func(i + 1, 0, profit, prices, dp)
    //         );
    //     }
    //     return dp[i][buy] = profit;
    // }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //         int[][] dp = new int[n + 1][2];
        //         // for(int[] d : dp)
        //         //     Arrays.fill(d, -1);
        //         // return func(0, 1, 0, prices, dp);

        //         dp[n][0] = 0;
        //         dp[n][1] = 0;

        //         for (int i = n - 1; i >= 0; i--) {
        //             for (int j = 0; j <= 1; j++) {
        //                 int profit = 0;
        //                 if (j == 1) {
        //                     profit = Math.max(
        //                             -prices[i] + next [0],
        //                             0 + next [1]);
        //                 }

        //                 else {
        //                     profit = Math.max(
        //                             prices[i] + dp[i+1][1],
        //                             0 + next [0]);
        //                 }
        //                  dp[i][j] = profit;
        //             }
        //         }
        // return dp[0][1];

        int[] next = new int[2];
        // for(int[] d : dp)
        //     Arrays.fill(d, -1);
        // return func(0, 1, 0, prices, dp);

        next[0] = 0;
        next[1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                if (j == 1) {
                    profit = Math.max(
                            -prices[i] + next[0],
                            0 + next[1]);
                }

                else {
                    profit = Math.max(
                            prices[i] + next[1],
                            0 + next[0]);
                }
                next[j] = profit;
            }
        }
        return next[1];     //At the beginning (day 0), you haven' t bought anything yet, so you're in the buy = 1 state. That means your first action can be a buy, and from there you alternate between buy and sell.

// So when you build your DP bottom-up, the final answer is stored in next[1], which represents the maximum profit starting from day 0 with the ability to buy.
    }
}
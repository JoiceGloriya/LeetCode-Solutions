class Solution {
    // int func(int i, int amount, int[] coins) {
    //     if (i == 0) {
    //         if (amount % coins[i] == 0) {
    //             return amount / coins[i];
    //         }
    //         return (int) (1e7);
    //     }

    //     int notTake = 0 + func(i - 1, amount, coins);
    //     int take = (int) (1e7);
    //     if (amount >= coins[i])
    //         take = 1 + func(i, amount - coins[i], coins);
    //     return Math.min(take, notTake);
    // }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int[][] dp = new int[n][amount + 1];
        int[] prev = new int[amount + 1];
            
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
            }
            else  prev[i] = (int) (1e7);
        }

        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar ++) {//since, here we' re given infinite supply of coins, traverse L to R, to avoid over-riding crt values
                int notTake = prev[tar];
                int take = (int) (1e7);
                if (tar >= coins[i])
                    take = 1 + prev[tar - coins[i]];
                prev[tar] = Math.min(take, notTake);
            }
        }
        if (prev[amount] == (int) (1e7))
            return -1;
        return prev[amount];
        // int val =  func(n - 1, amount, coins);
        //  if(val >= (int)(1e7))return -1;
        //  return val;
    }
}
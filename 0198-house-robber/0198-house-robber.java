class Solution {
    //memoization
    // int func(int[] dp, int ind,int[] nums) {
    //     if(ind == 0) return nums[0];
    //     if(ind < 0) return 0;

    //     if(dp[ind] != -1) return dp[ind];

    //     int pick = nums[ind] + func(dp, ind  - 2, nums);
    //     int nonPick = 0 + func(dp, ind  - 1, nums);

    //     return Math.max(pick, nonPick);
    // }

    public int rob(int[] nums) {
        int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return func(dp, nums.length - 1, nums);

        int prev = nums[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2;
            int nonPick = prev;

            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
}
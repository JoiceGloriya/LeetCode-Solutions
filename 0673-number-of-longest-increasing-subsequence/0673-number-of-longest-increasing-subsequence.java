class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxi = 0, ans = 0, ind = -1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] ct = new int[n];
        Arrays.fill(ct, 1);

        for(int i = 0; i < n; i ++) {
            
            for(int j = 0; j < i; j ++) {
                if(nums[i] > nums[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    ct[i] = ct[j];
                }
                else if(nums[i] > nums[j] && dp[i] == 1 + dp[j]) {     
                    ct[i] += ct[j];
                }  
            }
             if(dp[i] > maxi) {
                 maxi = dp[i];
             }
        }

        for(int i = 0; i < n; i ++) {
            if(dp[i] == maxi)
                ans += ct[i];
        }

        return ans;
    }
}
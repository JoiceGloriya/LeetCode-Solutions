class Solution {

    int func(int[] nums, int start, int end) {
        int prev = 0, prev2 = 0;
        for(int i = start; i <= end; i ++) {
            int pick = nums[i]+ prev2;
            int nonPick = prev;
            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
         int n = nums.length;
        if (n == 1) return nums[0];
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return func(dp, nums.length - 1, nums);
        int ans1 = func(nums, 0, n - 2);
        int ans2 = func(nums, 1, n - 1);
        return Math.max(ans2, ans1);
    }
}
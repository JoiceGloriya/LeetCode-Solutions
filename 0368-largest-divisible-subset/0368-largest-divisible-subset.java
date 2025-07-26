class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int ind = 0, maxi = 1;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int prevInd = 0;  prevInd <= i - 1; prevInd++) {
                if (nums[i] % nums[prevInd] == 0 &&  (dp[i] <= dp[prevInd] + 1) ) {  
                    dp[i] = dp[prevInd] + 1;
                    hash[i] = prevInd;
                }
            }
            if (maxi < dp[i]) {
                maxi = dp[i];
                ind = i;
            }
        }

        list.add(nums[ind]);

        while (hash[ind] != ind) {
            ind = hash[ind];
            list.add(nums[ind]);
        }
        return list;

    }
}
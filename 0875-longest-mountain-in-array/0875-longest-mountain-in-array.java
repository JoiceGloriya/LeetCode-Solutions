class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        int maxi = 0;

        for (int i = 1; i < n; i++) {
            // If the element at the current index is greater than the previous element,
            // we can extend the increasing subsequence. Increment dp[ind] by 1.
            if (arr[i] > arr[i - 1]) {
                dp1[i] = 1 + dp1[i-1];
            }

        }

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] > arr[i + 1]) {
                dp2[i] = 1 + dp2[i+1];

            }
        }

        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1)
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }
}
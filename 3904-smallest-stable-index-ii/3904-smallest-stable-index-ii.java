class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mini = new int[n];
        int maxi = nums[0];
        int min = nums[n - 1];
        mini[n - 1] = min;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < min)
                min = nums[i];

            mini[i] = min;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > maxi)
                maxi = nums[i];

            if (maxi - mini[i] <= k)
                return i;
        }
        return -1;
    }
}
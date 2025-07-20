class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, ct = 0, max_len = 0, k = 1;
        while (r < nums.length) {
            if (nums[r] == 0)
                ct++;
            if (ct > k) {
                if (nums[l] == 0)
                    ct--;
                l++;
            }
            // if(ct <= k)  this' ll always be true here, no need of checking.
            max_len = Math.max(max_len, (r - l + 1));
            r++;
        }
        return max_len - 1;
    }
}
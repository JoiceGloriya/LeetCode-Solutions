class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int lastSeen = -1;
        long ct = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (lastSeen == -1) {
                    ct++;
                    lastSeen = i;
                } else {
                    ct += i - lastSeen + 1;
                }
            } else
                lastSeen = -1;
        }
        return ct;
    }
}
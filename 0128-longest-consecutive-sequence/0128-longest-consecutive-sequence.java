class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int ct = 1, maxCt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                ct++;
                maxCt = Math.max(maxCt, ct);
            } else if (nums[i + 1] == nums[i])
                continue;
            else
                ct = 1;

        }
        return maxCt;
    }
}
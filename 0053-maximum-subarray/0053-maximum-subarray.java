class Solution {
    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (currSum < 0)
                currSum = 0;
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }

}
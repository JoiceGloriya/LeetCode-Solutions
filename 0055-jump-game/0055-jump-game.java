class Solution {
    public boolean canJump(int[] nums) {
        // int goal = nums.length - 1;
        // for(int i = nums.length - 1; i >= 0; i --) {
        //     if(i + nums[i] >= goal) {
        //         goal = i;
        //     }
        // }
        // // if(goal == 0) {
        // //     return true;
        // // }
        // return goal == 0;

        int maxInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxInd)
                return false; //u were not able to reach at i, so return false
            maxInd = Math.max(maxInd, i + nums[i]);
            if (maxInd >= nums.length)
                return true;
        }
        return true;
    }
}
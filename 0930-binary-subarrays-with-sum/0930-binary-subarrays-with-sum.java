class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums, goal) - func(nums, goal - 1);
    }

//T.C : O(2*2N) ~ O(N) and S.C : O(1)

    private int func(int[] nums, int goal) {
        int sum = 0, ct = 0, l = 0, r = 0;
        if (goal < 0)
            return 0; // essential testcase when given goal = 0 , for the (atmost goal - 1) case, its not possible! (bcoz my input consists of only +ve numbers).
        while (r < nums.length) { // amortized 
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            ct += (r - l + 1);
            r++;
        }
        return ct;
    }
}
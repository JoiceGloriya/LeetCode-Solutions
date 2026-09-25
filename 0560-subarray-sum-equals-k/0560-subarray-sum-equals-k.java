class Solution {
    public int subarraySum(int[] nums, int k) {
        //this SLINDING WINDOW approach'll not wrk since array contains -ve elemnts, so i' ll be using prefSum concept.
        // int l = 0, r = 0, sum = 0, ct = 0;
        // while(r < nums.length) {
        //     sum += nums[r];
        //     while(sum > k && (l+1) < nums.length) {
        //         sum -= nums[l];
        //         l++;
        //     }
        //     if(sum == k) ct++;
        //     r++;
        // }
        // return ct; 

        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int prefSum = 0, ct = 0;
        for(int num : nums) {
            prefSum += num;
            if(mpp.containsKey(prefSum - k))
                ct += mpp.get(prefSum - k);
            mpp.put(prefSum, mpp.getOrDefault(prefSum, 0)+1);
        }
        return ct;
    }
}
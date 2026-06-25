class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> mpp = new HashMap<>();
        mpp.put(0L, 1);
        long prefSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            
            long rem = prefSum - k;
            if (mpp.containsKey(rem)) {
                sum += mpp.get(rem);
            }

            mpp.put(prefSum, mpp.getOrDefault(prefSum, 0) + 1);
        }
        return sum;
    }
}
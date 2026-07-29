class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();

        while(r < n) {
            if((r - l) > k) {
                set.remove(nums[l]);
                l++;
            }
            if(set.contains(nums[r]))
                return true;
            set.add(nums[r]);
            r++;
        }

       
        return false;
    }
}
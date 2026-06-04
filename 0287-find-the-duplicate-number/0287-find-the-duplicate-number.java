class Solution {
    public int findDuplicate(int[] nums) {
        // Set<Integer> seen = new HashSet<>();

        // for(int i = 0; i < nums.length; i ++) {
        //     if(seen.contains(nums[i])) return nums[i];
        //     seen.add(nums[i]);
        // }
        // return -1;

        //Floyd's Cycle

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
}
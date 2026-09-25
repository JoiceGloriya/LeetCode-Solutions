class Solution {
    public int longestConsecutive(int[] nums) {
        //Optimal

        if(nums.length == 0) return 0;
        int ct = 0, longest = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for(int i : set) {
            if(!set.contains(i-1)) {
                int x = i;
                ct = 1;
                while(set.contains(x+1)) {
                    x = x + 1;
                    ct++;
                }
                longest = Math.max(longest, ct);
            }
            
        }
        return longest;

    }
}
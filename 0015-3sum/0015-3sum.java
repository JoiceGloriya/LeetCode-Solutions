class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> hashset = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     Set<Integer> obj = new HashSet<>();    //initializing a new hashset for evry 'i'
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int third = -(nums[i] + nums[j]);
        //         if (obj.contains(third)) {
        //             List<Integer> arr = Arrays.asList(nums[i], nums[j], third);
        //             arr.sort(null);
        //             hashset.add(arr);
        //         }
        //         obj.add(nums[j]); // adding last element to obj hashset
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList(hashset);
        // return ans;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) //then nums[j] and nums[k] will also be 0, hence we cant achieve traget(jus an optimization)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++; // j < k ensures that my array is sorted.
                    while (j < k && nums[k + 1] == nums[k])
                        k--; // skipping duplicates for 'j' and 'k'.
                }
            }
        }
        return ans;
    }
}
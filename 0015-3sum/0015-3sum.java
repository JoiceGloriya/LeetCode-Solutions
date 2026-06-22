class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> hashset = new HashSet<>();
        for(int i = 0; i < nums.length; i ++) {
            Set<Integer> obj = new HashSet<>();
            for(int j = i + 1; j < nums.length; j ++) {
                int third = -(nums[i] + nums[j]);
                if(obj.contains(third)) {
                    List<Integer> arr  = Arrays.asList(nums[i], nums[j], third);
                    arr.sort(null);
                    hashset.add(arr);
                }
                obj.add(nums[j]);
            }
        }
       List<List<Integer>> ans = new ArrayList(hashset); 
       return ans;
    }
}
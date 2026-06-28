class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(helper(nums, 0, new ArrayList<Integer>(), new HashSet<List<Integer>>()));
    }

    public HashSet<List<Integer>> helper(int[] nums, int i, List<Integer> al, HashSet<List<Integer>> list) {
        if (i == nums.length) {
            list.add(new ArrayList<>(al));
            return list;
        }
        al.add(nums[i]);
        helper(nums, i + 1, al, list);
        al.remove((Object) nums[i]);
        helper(nums, i + 1, al, list);
        return list;
    }
}
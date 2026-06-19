class Solution {
    public static int[] twoSum(int[] nums, int target) {
        //BF : TC -> O(N*N)  SC -> O(1)
        // int[] arr = new int[2];
        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             arr[0] = i;
        //             arr[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return arr;

        //Optimal (hashing)
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (mpp.containsKey(rem)) {
                int ind = mpp.get(rem);
                return new int[] { ind, i };
            }
            mpp.put(nums[i], i);
        }
        return new int[] {};
    }
}
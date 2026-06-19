class Solution {
   public static void rotate(int[] nums, int k) {
    k = k % nums.length;
       reverse(nums, 0, nums.length-1);// reverse the entire array first.
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
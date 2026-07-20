class Solution {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // boolean isAsc = false;
        // if (nums[start] < nums[end]) //checking for agnostic array.
        // isAsc = true;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            // if (isAsc) {
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
            // }
            // else
            // {
            // if (nums[mid] < target)
            // end = mid - 1;
            // else if (nums[mid] > target)//else
            // start = mid + 1;
            // }
        }
        return -1;
    }
}

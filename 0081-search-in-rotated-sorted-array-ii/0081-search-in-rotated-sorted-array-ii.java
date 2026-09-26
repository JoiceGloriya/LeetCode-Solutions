class Solution {
    public boolean search(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;

            // This check is needed when duplicates make it impossible to determine
            // which half is sorted, e.g [7,7,7,7,1,2,7] where
            // nums[s] == nums[mid] == nums[e] == 7. In that case, shrink both ends.

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;//mid calc has to happen again.
            } 
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return false;
    }
}
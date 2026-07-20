class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = lowerBound(nums, target);

        if (first == nums.length || nums[first] != target)
            return new int[] { -1, -1 };

        int last = upperBound(nums, target) - 1;

        return new int[] { first, last };
    }

    // First index where nums[i] >= target
    int lowerBound(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return s;
    }

    // First index where nums[i] > target
    int upperBound(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return s;
    }
}
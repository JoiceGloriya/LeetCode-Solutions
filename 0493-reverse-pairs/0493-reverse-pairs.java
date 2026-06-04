class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int low, int high) {
        int ct = 0;
        if (low == high)
            return ct;
        int mid = (low + high) / 2;
        ct += mergeSort(nums, low, mid);
        ct += mergeSort(nums, mid + 1, high);
        ct += countRevPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return ct;
    }

    void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }

        while (right <= high) {
            list.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++)
            nums[i] = list.get(i - low);
    }

    int countRevPairs(int[] nums, int low, int mid, int high) {
        int ct = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)nums[i]> 2L * nums[right])
                right++;
            ct += right - (mid + 1); // variable right ptr - initial pos of right ptr i.e "mid+1'".
        }

        return ct;
    }
}
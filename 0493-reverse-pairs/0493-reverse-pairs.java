class Solution {

    // TC -> O(NlogN + N)    SC -> O(N)
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        int ct = 0;
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        ct += mergeSort(arr, low, mid);
        ct += mergeSort(arr, mid + 1, high);
        ct += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return ct;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> a = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                a.add(arr[left]);
                left++;
            } else {
                a.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            a.add(arr[left]);
            left++;
        }
        while (right <= high) {
            a.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++)
            arr[i] = a.get(i - low);
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int ct = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (2L * arr[right]))
                right++;
            ct += (right - (mid + 1));
        }
        return ct;
    }
}
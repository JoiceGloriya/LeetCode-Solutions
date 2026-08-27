class Solution {
    public int findKthPositive(int[] arr, int k) {
        // BruteForce TC -> O(N)
        // for(int i = 0; i < arr.length; i ++) {
        // if(arr[i] <= k) k++; // then this number would occupy a place, that' s why
        // else break;
        // }
        // return k;

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int miss = arr[mid] - (mid + 1); // (mid + 1) is the ideal number to be present in that position
            if (miss < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start + k;
        //return arr[high] + k - (arr[high] - (high + 1))
        // 7 + 5 -(7 -(3 + 1)) = 7 + 5 - 3 = 7 + 2 = 9
        // return end + 1 + k;
    }
}
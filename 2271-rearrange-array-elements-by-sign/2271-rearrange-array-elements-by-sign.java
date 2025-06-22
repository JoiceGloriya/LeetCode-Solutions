class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Brute Force
        //TC -> O(2N) SC -> O(N)
        int j = 0, k = 0, n = nums.length;
        int[] p_arr = new int[n / 2];
        int[] n_arr = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                p_arr[j++] = nums[i];
            else
                n_arr[k++] = nums[i];
        }

        j = 0;
        int i = 0;
        // for(int i = 0; i < n/2; i ++) {
        //     nums[j++] = p_arr[i];
        //     nums[j++] = n_arr[i];
        // }

        while (i < n / 2) {
            nums[j++] = p_arr[i];
            nums[j++] = n_arr[i];
            i++;
        }
        return nums;

        //Optimal

        // int[] ans = new int[nums.length];
        // int posIndex = 0, negIndex = 1;
        // for(int i = 0; i < nums.length; i ++) {
        //     if(nums[i] > 0) {
        //     ans[posIndex] = nums[i];
        //     posIndex += 2;
        //     }
        //     else {
        //         ans[negIndex] = nums[i];
        //         negIndex += 2;
        //     }
        // }

        // return ans;
    }
}
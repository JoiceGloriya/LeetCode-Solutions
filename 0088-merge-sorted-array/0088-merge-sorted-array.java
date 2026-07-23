class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Extreme Brute-Force approach
        // for(int i = m, j = 0; j < n; j ++) {
        //     nums1[i] = nums2[j];
        //     i++;
        // }
        // Arrays.sort(nums1);

        //Approach 1 :-
        //     int i = 0, j = 0, k = 0;
        //     int[] temp = new int[nums1.length];

        //     while(i < m && j < n) {
        //         if(nums1[i] < nums2[j])
        //          temp[k++] = nums1[i++];
        //          else
        //          temp[k++] = nums2[j++];
        //     }

        //    while(i < m)
        //    temp[k++] = nums1[i++];

        //    while(j < n)
        //    temp[k++] = nums2[j++];

        // for(int ind = 0; ind < nums1.length; ind ++)
        // nums1[ind] = temp[ind];

        //Optimal : Two Pointer
        //Time complexity: O(m+n)
        //Space complexity: O(1)

        int i = m - 1, j = n - 1, k = nums1.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
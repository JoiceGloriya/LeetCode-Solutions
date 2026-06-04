class Solution {
    
        public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int exp = nums[i] - 1;
            if(nums[i] != (i + 1)) {
            if ( nums[i] != nums[exp]) {
                swap(nums, i, exp);
            }
            else {
                return nums[i];
            }
            }
            else {
                i++;
            }
        }
        return  0;
    }
    private static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
    }

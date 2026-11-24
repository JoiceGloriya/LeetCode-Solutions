class Solution {
   static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int exp = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[exp]) {
                swap(nums, i, exp);
            } else {
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j]) {
                return j;
            }
        }
        return nums.length;
    }

    private static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
     public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int ans = missingNumber(nums);
        System.out.println(ans);
    }

}
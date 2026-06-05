class Solution {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // boolean isAsc = false;
        // if (nums[start] < nums[end]) //checking for agnostic array.
        //     isAsc = true;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            // if (isAsc) {
                if (nums[mid] > target)
                    end = mid - 1;
                else if (nums[mid] < target)//else
                    start = mid + 1;
            // }
            // else
            // {
            //     if (nums[mid] < target)
            //         end = mid - 1;
            //     else if (nums[mid] > target)//else
            //         start = mid + 1;
            // }
        }
        return -1;
    }
     public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter nums elements :");
        for(int i=0; i<n; i++)
            nums[i] = scn.nextInt();
        System.out.println("Enter target : ");
        int target = scn.nextInt();
        int ans = search(nums, target);
        System.out.println("Answer : "+ans);
    }
}
    
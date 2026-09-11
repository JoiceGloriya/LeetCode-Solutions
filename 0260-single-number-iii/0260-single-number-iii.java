class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++)
            xor = (xor ^ nums[i]);

        int rightmost = ((xor & (xor - 1)) ^ xor); // this will find the rightmost bit that is different in both since
                                                   // that is easier to find..only that bit will be set and the rest will be 0
        int bucket_1 = 0, bucket_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((rightmost & nums[i]) != 0)
                bucket_1 ^= nums[i];
            else
                bucket_2 ^= nums[i];
        }
        return new int[] { bucket_1, bucket_2 };
    }
}
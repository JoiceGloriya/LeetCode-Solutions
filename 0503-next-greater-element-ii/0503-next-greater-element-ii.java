class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // TC -> O(4N)
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {// => O(2N)
            int ind = i % n;
            while (!stk.isEmpty() && nums[ind] >= stk.peek()) // => O(2N) [Wrst case -> arr is desc]
                stk.pop();
            if (i < n)
                ans[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[ind]);
        }
        return ans;
    }
}
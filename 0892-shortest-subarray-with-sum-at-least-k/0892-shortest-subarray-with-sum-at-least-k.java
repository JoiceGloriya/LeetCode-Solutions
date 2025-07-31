class Solution {
    public int shortestSubarray(int[] nums, int k) {

        // Why SLIDING WINDOW doesn' t wrk for this sum ? consider [-1, 2, 1] and k = 2 , when we are at l = 0, r = 1, our sum would be +1, but we say, since sum < k , we can' t achieve our target of 2, so there' s no point in shrinking l, so we let r to increment, which is why we end up with output of 2, but technically it shld be 1

        // Subarrays strts with -ve as well as subarrays that strt with +ves followed by some -ve ruin our goal

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, minLen = n + 1;

        

        long[] prefSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefSum[i] - prefSum[dq.peekFirst()] >= k)
                minLen = Math.min(minLen, i - dq.pollFirst());

            while (!dq.isEmpty() && prefSum[i] <= prefSum[dq.peekLast()])
                dq.pollLast();

            dq.offer(i);
        }

        return minLen == n + 1 ? -1 : minLen;

    }
}
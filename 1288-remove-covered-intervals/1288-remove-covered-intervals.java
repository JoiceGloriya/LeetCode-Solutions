class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int e = intervals[0][1];
        int n = intervals.length;
        int ans = n;

        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= e)
                ans--;
            else {
                e = intervals[i][1];
            }
        }
        return ans;
    }
}
class Solution {//this prob is an exact replica of 'N-MEETINGS IN A ROOM' where i was given a job to find the max num of meetings i can attend (in a non-ovrlapping manner), so return intervals.length - ans(from that prob)

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int ct = 1; //cuz first interval is always non-overlapping
        int n = intervals.length;

        // List<int[]> list = new ArrayList<>();
        for (int i = 1; i < n; i ++) {
            // if (list.isEmpty() || end <= intervals[0]) {
            if (end <= intervals[i][0]) {
                // list.add(intervals);
                end = intervals[i][1]; 
                ct++;
            }
        }
        // return n - list.size();
        return n - ct;
    }
}
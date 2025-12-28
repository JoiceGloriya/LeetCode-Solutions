class Solution {
    public int countNegatives(int[][] grid) {
    //     int ct = 0;
    //     for (int i[] : grid) {
    //         int start = 0;
    //         int end = i.length - 1;
    //         while (start <= end) {
    //             int mid = start + (end - start) / 2;
    //             if (i[mid] >= 0) {
    //                 start = mid + 1;
    //             } else {
    //                 if(mid == 0 || (i[mid - 1] >= 0)) {
    //                 ct += i.length - mid;
    //                 break;
    //             }
    //             else {
    //                 end = mid - 1;
    //                 }
    //             }
    //         }
    //     }
    //     return ct;
    // } this is O(mlogN) but question is gn as both row and col-sorted, so see the follow-up.
    int ct = 0;
    int m = grid.length;
    int n = grid[0].length;
    int row = 0;
    int col = n - 1;
    while(row < m && col >= 0) {
        if(grid[row][col] < 0) {
            ct += (m - row);
            col --;
        }
        else {
            row ++;
        }
    }
    return ct;
    }
}
class Solution {
    public static int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length - 1;

        while (start <= end) {
            int midCol = start + (end - start) / 2;
            int row = findMax(mat, midCol);    //finding max in midCol-th col
            int left = -1, right = -1;

            if (midCol - 1 >= 0)
                left = mat[row][midCol - 1];
            if (midCol + 1 < mat[0].length)
                right = mat[row][midCol + 1];
            if ((mat[row][midCol] > left) && (mat[row][midCol] > right)) {
                return new int[] { row, midCol };
            } else if (mat[row][midCol] < left) {
                end = midCol - 1;
            } else {
                start = midCol + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public static int findMax(int[][] mat, int midCol) {
        int max = mat[0][midCol];
        int row = 0;
        for (int i = 1; i < mat.length; i++) {
            if (max < mat[i][midCol]) {
                row = i;
                max = mat[i][midCol];
            }
        }
        return row;
    }
}
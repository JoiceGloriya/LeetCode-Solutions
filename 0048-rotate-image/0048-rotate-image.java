class Solution {

    public void rotate(int[][] matrix) {
        //TC -> O(N^2)
        //SC -> O(1) in-place
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, j, i, i, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix.length - 1;
            while(start < end) {
                swap(matrix, i, start, i, end);
                start++;
                end--;
            }
        }

    }

    private void swap(int[][] matrix, int a, int b, int c, int d) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = temp;
    }
}
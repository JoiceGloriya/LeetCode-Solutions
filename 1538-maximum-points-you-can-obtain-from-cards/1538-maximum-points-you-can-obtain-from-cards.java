class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l_sum = 0;
        int r_sum = 0;
        int max_sum = 0;
        for(int i = 0; i < k; i ++) {//initialising with first k-values' sum 
            l_sum += cardPoints[i];
        }
        max_sum = l_sum;
        int ind = cardPoints.length - 1;
        for(int i = k - 1; i >= 0; i --) { //removal starts from k - 1 th element
            l_sum -= cardPoints[i];   // removing element at ith index.
            r_sum += cardPoints[ ind--];    // adding element at ind-th index.
            max_sum = Math.max(max_sum, l_sum + r_sum);
        }
       return max_sum; 
    }
}
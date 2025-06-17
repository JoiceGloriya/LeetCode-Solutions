class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[] prev = new int[ n + 1];

        for(int i = 1; i <= n; i ++) {
            int[] temp = new int[ n + 1];
            for(int j = 1; j <= n; j ++) {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    temp[j] = 1 + prev[j - 1];
                else
                    temp[j] = Math.max(prev[j], temp[ j - 1]);
            }
            prev  =temp;
        }

        return prev[n];
    }
}
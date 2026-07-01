class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for (int startIndex = n - 1; startIndex >= 0; startIndex--) {
            for (int i = startIndex; i < n; i++) {
                if (set.contains(s.substring(startIndex, i + 1)) && dp[i + 1]) {
                    dp[startIndex] = true;
                    break;
                }
            }
        }
        return dp[0];

    }

}
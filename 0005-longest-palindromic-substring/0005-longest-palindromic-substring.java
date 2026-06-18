class Solution {
    boolean isPalindrome(String s, int start, int e) {
        while (start < e) {
            if (s.charAt(start) != s.charAt(e))
                return false;
            start++;
            e--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        String ans = s.charAt(0) + "";

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (maxLen < (j - i + 1)) {
                        maxLen = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
}
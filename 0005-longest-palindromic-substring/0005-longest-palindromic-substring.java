class Solution {

    String findPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int n = s.length();
        String finalPalindrome = s.substring(0, 1);
        for (int i = 0; i < n - 1; i++) {
            String oddCenteredPalindrome = findPalindrome(s, i, i);
            String evenCenteredPalindrome = findPalindrome(s, i, i + 1);
            if (oddCenteredPalindrome.length() > finalPalindrome.length())
                finalPalindrome = oddCenteredPalindrome;
            if (evenCenteredPalindrome.length() > finalPalindrome.length())
                finalPalindrome = evenCenteredPalindrome;
        }
        return finalPalindrome;
    }
}
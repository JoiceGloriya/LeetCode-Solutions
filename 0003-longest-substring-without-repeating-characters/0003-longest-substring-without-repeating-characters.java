class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 1;
        int n = s.length();
        if (n == 0)
            return 0;
        Map<Character, Integer> mpp = new HashMap<>();

        while (r < n) {
            char c = s.charAt(r);
            if (mpp.containsKey(c)) {
                if (l <= mpp.get(c)) {
                    l = mpp.get(c) + 1;
                    mpp.put(c, r);
                }
            }
            int len = r - l + 1;
            mpp.put(c, r);
            maxLen = Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}
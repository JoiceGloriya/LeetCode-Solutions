class Solution {
    public int longestSubstring(String s, int k) {
        // Optimal:
        // TC -> O(N*maxUnique) but maxUnique can be at most 26 so O(N)
        // SC -> O(26) taken by hash[]
        if (s == null || s.isEmpty() || k > s.length())
            return 0;

        int maxUnique = 0, maxLen = 0;
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            if (hash[c - 'a'] == 0)
                maxUnique++;
            hash[c - 'a']++;
        }

        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            int l = 0, r = 0, countAtleastK = 0, unique = 0;
            Arrays.fill(hash, 0);
            while (r < s.length()) {
                if (unique <= currUnique) {
                    if (hash[s.charAt(r) - 'a'] == 0)
                        unique++;
                    hash[s.charAt(r) - 'a']++;
                    if (hash[s.charAt(r) - 'a'] == k)
                        countAtleastK++;
                    r++;
                } else {
                    if (hash[s.charAt(l) - 'a'] == k)
                        countAtleastK--;
                    hash[s.charAt(l) - 'a']--;
                    if (hash[s.charAt(l) - 'a'] == 0)
                        unique--;
                    l++;
                }
                if (unique == currUnique && unique == countAtleastK)
                    maxLen = Math.max(maxLen, r - l);
            }
        }

        return maxLen;
    }
}
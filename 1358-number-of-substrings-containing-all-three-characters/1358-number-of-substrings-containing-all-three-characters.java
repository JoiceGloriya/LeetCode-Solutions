class Solution {
    public int numberOfSubstrings(String s) {
        // T.C : O(N) and S.C : O(1)
        int[] hash = { -1, -1, -1 };
        int ct = 0;
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1)
                ct += Math.min(hash[0], Math.min(hash[1], hash[2])) + 1;
        }
        return ct;
    }
}
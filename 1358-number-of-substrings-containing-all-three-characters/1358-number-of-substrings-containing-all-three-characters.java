class Solution {
    public int numberOfSubstrings(String s) {
        // T.C : O(N) and S.C : O(1)
        int[] hash = { -1, -1, -1 };
        int ct = 0;
        int n =s.length();
        for (int i = n - 1; i >= 0; i--) {
            hash[s.charAt(i) - 'a'] = i;
            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1)
                ct = ct +  n - Math.max(hash[0], Math.max(hash[1], hash[2])) ;
        }
        return ct;
    }
}
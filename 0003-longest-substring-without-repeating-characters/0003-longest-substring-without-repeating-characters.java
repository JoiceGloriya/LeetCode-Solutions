class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxlen = 0;
        int[] hash = new int[256]; // Possible distinct values is ASCII values 0 to 255.
        Arrays.fill(hash, -1);
        for (int r = 0; r < s.length(); r++) {
           if(hash[s.charAt(r)] != -1) {   //then it's already available
            if(hash[s.charAt(r)] >= l) { 
               l = Math.max(l, hash[s.charAt(r)]+ 1);
            }
           }
        hash[s.charAt(r)] = r;
        maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
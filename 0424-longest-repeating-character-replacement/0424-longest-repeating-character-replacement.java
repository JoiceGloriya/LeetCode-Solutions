class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int maxlen = 0, maxf = 0, l = 0;
        for(int r = 0; r < s.length(); r ++) {
            arr[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, arr[s.charAt(r) - 'A']);
            while((r - l + 1) - maxf > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
                // maxf = Math.max(maxf, arr[s.charAt(r) - 'A']);
            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
return maxlen;
    }
}
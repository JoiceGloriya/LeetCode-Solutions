class Solution {
    int computeBeauty(int[] freq) {
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int i : freq) {
            if(i != 0) {
                mini = Math.min(mini, i);
                maxi = Math.max(maxi, i);
            }
        }
        return maxi - mini;
    }
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i ++) {
            int[] freq = new int[26];
            for(int j = i; j < n; j ++) {
                freq[s.charAt(j) - 'a']++;
                res += computeBeauty(freq);
            }
        }
        return res;
    }
}
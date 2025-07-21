class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] hash = new int[26];

        for (char c : word1.toCharArray())
            hash[c - 'a']++;

        int[] hash1 = new int[26];

        for (char c : word2.toCharArray())
            hash1[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0 && hash1[i] == 0 || (hash1[i] != 0 && hash[i] == 0)) 
               return false;
        }

        Arrays.sort(hash);
        Arrays.sort(hash1);

        for (int i = 0; i < 26; i++) {
            if (hash[i] != hash1[i]) {
                return false;
            }
        }
return true;
    }
}
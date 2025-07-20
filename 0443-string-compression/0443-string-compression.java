class Solution {
    public int compress(char[] chars) {
        int j = 0;
        int ct = 0;
        char prev = chars[0];

        for (int i = 0; i < chars.length && j < chars.length; i++) {
            char c = chars[i];
            if (i > 0 && c != prev) {
                chars[j] = prev;
                j++;
                if (ct != 1) {
                    String s = String.valueOf(ct);
                    for (int k = 0; k < s.length(); k++) {
                        chars[j] = s.charAt(k);
                    j++;
                    }

                }
                prev = c;
                ct = 1;
            } else {
                ct++;
            }
        }
        chars[j] = prev;
        j++;
        if (ct != 1) {
            String s = String.valueOf(ct);
            for (int k = 0; k < s.length(); k++) {
                chars[j] = s.charAt(k);
                j++;
            }

        }
        return j;
    }
}
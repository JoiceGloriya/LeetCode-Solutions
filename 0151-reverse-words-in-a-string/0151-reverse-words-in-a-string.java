class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        char arr[] = s.toCharArray();
        int n = arr.length;
        reverse(arr, 0, n - 1);
        s = new String(arr);
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (i < n && s.charAt(i) == ' ')
                i++;

            StringBuilder word = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }

            char[] temp = word.toString().toCharArray();
            reverse(temp, 0, temp.length - 1);
            word = new StringBuilder(new String(temp));

            if (ans.length() > 0)
                ans.append(" ");
            ans.append(word);
        }
        return ans.toString();
    }

    void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
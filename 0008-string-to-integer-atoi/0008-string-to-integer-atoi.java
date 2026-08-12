class Solution {
    public static int myAtoi(String s) {
        if (s.isEmpty())
            return 0;
        int result = 0, sign = 1, n = s.length(), i = 0;

        while (i < n && s.charAt(i) == ' ')
            i++;
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+')
            i++;
        while (i < n && s.charAt(i) == '0')
            i++;
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                char c = s.charAt(i); //cuz Integer.MAX_VALUE is 2147483647
                if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10)
                        && (c - '0') > 7)) {
                    if (sign == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                } else
                    result = result * 10 + (c - '0');
                i++;
            } else
                return result * sign;

        }
        return result * sign;  // then, u re given a valid string
    }
}
class Solution {
    // public String gcdOfStrings(String str1, String str2) {
    //     if (str2.length() > str1.length())
    //         return gcdOfStrings(str2, str1);

    //     if (str1.equals(str2))
    //         return str1;

    //     if (str1.startsWith(str2))
    //         return gcdOfStrings(str1.substring(str2.length()), str2);
    //     // Keeps trimming the prefix (str2) from str1
    //     return "";
    // }

    public String gcdOfStrings(String str1, String str2) {

        if (!((str1 + str2).equals(str2 + str1)))
            return "";
        int gcd = findGCD(str1, str2);
        return str2.substring(0, gcd);
    }

    int findGCD(String str1, String str2) {
        int a = str1.length(), b = str2.length();
        while (a > 0 && b > 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        if (a == 0)
            return b;
        return a;
    }
}
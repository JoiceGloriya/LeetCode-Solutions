class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.length() > str1.length()) return gcdOfStrings(str2, str1);

        if(str1.equals(str2)) return str1;

        if(str1.endsWith(str2)) return gcdOfStrings(str1.substring(0, str1.length() - str2.length()), str2);
        // Keeps trimming the prefix (str2) from str1
        return "";
    }
}
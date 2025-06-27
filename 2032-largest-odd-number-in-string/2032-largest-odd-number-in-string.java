class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int val = num.charAt(n - 1);
        if(val % 2 ==1) return num;

        for(int  i = n - 2; i >= 0; i--) {
            int value = num.charAt(i);
            if(value % 2 ==1) return num.substring(0, i+1);
        }
        return "";
    }
}
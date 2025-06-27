class Solution {
    // StringBuilder findMatch(String a, String b) {
        // int  i = 0, j = 0;
        // StringBuilder ans = new StringBuilder();
        // while(i < a.length() && j < b.length()) {
        //     if(a.charAt(i) == b.charAt(j)) {
        //         ans.append(a.charAt(i));
        //         i++;
        //         j++;
        //     }
        //     else break;
        // }
        // return ans;


    // }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        // StringBuilder ans = findMatch(strs[0], strs[1]);
        int n = strs.length;
       
        // for(int i = 2; i < n; i ++) {
        //     ans =  findMatch(ans.toString(), strs[i]);
        // }
        // return ans.toString();

        //Optimal -> Sorting
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n - 1];
int i  =0;
        for( i = 0; i < Math.min(first.length(), last.length()); i+=1) {
            if(first.charAt(i) != last.charAt(i)) return first.substring(0, i);
        }
       return first.substring(0, i);
    }
}
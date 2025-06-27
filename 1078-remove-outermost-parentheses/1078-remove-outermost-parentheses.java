class Solution {
    public String removeOuterParentheses(String s) {
        // Better: TC -> O(N) SC -> O(N)
        StringBuffer str = new StringBuffer();
        // int j = 0;
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!stk.isEmpty())
                    str.append('(');
                stk.push('(');
            } else {
                if (!stk.isEmpty())
                    stk.pop();
                if (!stk.isEmpty())
                    str.append(')');
            }
        }

        return str.toString();

        // Optimal TC -> O(N) SC -> O(N) (to return ans only!)
        // int ct = 0;
        // StringBuffer str = new StringBuffer();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(') {
        //         ct++;
        //         if (ct > 1)
        //             str.append('(');
        //     } else {
        //         ct--;
        //         if (ct > 0)
        //             str.append(')');
        //     }
        // }
        // return str.toString();
    }
}
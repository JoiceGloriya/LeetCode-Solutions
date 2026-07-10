class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stk.isEmpty() && k > 0 && num.charAt(i) - '0' < stk.peek() - '0') {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        while (!stk.isEmpty() && k > 0) { // trim-off last 'k' numbers -> the stk would be of type '123456'
            stk.pop();
            k--;
        }

        if (stk.isEmpty())  //consider : "123" and k  = 3
            return "0";

        while (!stk.isEmpty()) {
            str = str.append(stk.pop());
        }

        str.reverse();
        
        while (!str.isEmpty() && str.charAt(0) == '0') // trim-off leading zeroes
            str.deleteCharAt(0);

        if (str.isEmpty())
            return "0";
        return str.toString();
    }
}
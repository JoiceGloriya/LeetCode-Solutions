class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        backtrack(0, num, 0L, 0L, target, "", list);
        return list;
    }

    void backtrack(int startIndex, String num, long currSum, long prevNum, int target, String ans, List<String> list) {
        if (startIndex == num.length()) {
            if (currSum == target)
                list.add(ans);
            return;
        }
        for (int i = startIndex; i < num.length(); i++) {
            if (i > startIndex && num.charAt(startIndex) == '0') // 54 + 0+ 3 -> is valid , but 54 + 03 is invalid
                break;

            long currNum = Long.parseLong(num.substring(startIndex, i + 1));
            if (startIndex == 0) {
                backtrack(i + 1, num, currNum, currNum, target, ans + currNum, list);
            } else {
                backtrack(i + 1, num, currSum + currNum, currNum, target, (ans + "+" + currNum), list);
                backtrack(i + 1, num, currSum - currNum, -currNum, target, (ans + "-" + currNum), list);
                backtrack(i + 1, num, ((currSum - prevNum) + (prevNum * currNum)), (prevNum * currNum), target,
                        (ans + "*" + currNum), list);
            }
        }
    }
}
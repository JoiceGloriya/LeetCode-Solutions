class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        int n = digits.length;
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;
                    num = 100 * digits[i] + 10 * digits[j] + digits[k];
                    if (digits[i] != 0 && digits[k] % 2 == 0)
                        set.add(num);
                }
            }
        }

        return set.size();

    }
}
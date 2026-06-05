class Solution {

    private static final int[] WAVE_PATTERNS = new int[570];

    static {
        int index = 0;

        for (int num = 0; num < 1000; num++) {
            int right = num % 10;
            int middle = (num / 10) % 10;
            int left = (num / 100) % 10;

            if (middle > Math.max(left, right) ||
                    middle < Math.min(left, right)) {
                WAVE_PATTERNS[index++] = num;
            }
        }
    }

    public long totalWaviness(long A, long B) {
        return countWavyNumbers(B) - countWavyNumbers(A - 1);
    }

    private long countWavyNumbers(long num) {
        if (num < 100)
            return 0;

        long result = 0;

        for (int pattern : WAVE_PATTERNS) {
            result += countOccurrences(num, pattern);
        }

        return result;
    }

    private long countOccurrences(long num, int pattern) {

        long leadingZeroType = (pattern < 100) ? 1 : 0;

        long totalWays = 0;
        long placeValue = 1;

        for (int position = 0; position < 16; position++) {

            if (placeValue * 100 > num)
                break;

            long prefix = num / (placeValue * 1000);
            long currentBlock = (num / placeValue) % 1000;
            long suffix = num % placeValue;

            long count = 0;
            long edgeContribution = 0;

            if (currentBlock > pattern) {

                count = prefix - leadingZeroType + 1;

            } else if (currentBlock == pattern) {

                count = Math.max(0L, prefix - leadingZeroType);

                if (prefix >= leadingZeroType) {
                    edgeContribution = suffix + 1;
                }

            } else {

                count = Math.max(0L, prefix - leadingZeroType);
            }

            totalWays += count * placeValue + edgeContribution;

            placeValue *= 10;
        }

        return totalWays;
    }
}
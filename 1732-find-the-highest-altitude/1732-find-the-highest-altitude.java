class Solution {
    public static int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;
        for (int i = 1; i < altitude.length; i++) {
            altitude[i] = altitude[i - 1] + gain[i - 1];
        }
        int large = altitude[0];
        for (int i = 1; i < altitude.length; i++) {
            if (altitude[i] > large)
                large = altitude[i];
        }
        return large;
    }

    public static void main(String args[]) {
        int[] gain = { -5, 1, 5, 0, -7 };
        int ans = largestAltitude(gain);
    }
}
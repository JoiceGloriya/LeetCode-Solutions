class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int start = weights[0];
        int end = weights[0];

        for (int i = 1; i < weights.length; i++) {
            end += weights[i];
            start = Math.max(start, weights[i]);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (search(weights, days, mid))
                end = mid - 1;
            else
                start = mid + 1;

        }
        return start;
    }

    boolean search(int[] weights, int days, int cap) {

        int load = 0;
        int daysTaken = 1;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > cap) { //per-day loading capacity reached
                daysTaken++; //new day
                load = weights[i]; //new load
            } else {
                load += weights[i]; //loading on the same day
            }
        }
        return (daysTaken <= days);
    }

}
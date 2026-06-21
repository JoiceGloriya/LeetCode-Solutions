class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int i = 0, n = costs.length;
        Arrays.sort(costs);
        while(i < n) {
            if(costs[i] <= coins)  {
                coins -= costs[i];
                i++;
            }
            else return i;
        }
        return n;
    }
}
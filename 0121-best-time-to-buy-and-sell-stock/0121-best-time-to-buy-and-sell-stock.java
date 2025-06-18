class Solution {
    public int maxProfit(int[] prices) {
        int costPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int val = prices[i] - costPrice;
            profit = Math.max(profit, val);
            costPrice = Math.min(costPrice, prices[i]);
        }
        return profit;
    }
}
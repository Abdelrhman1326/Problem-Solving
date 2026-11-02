class Solution {
    public int maxProfit(int[] prices) {
        int total_profit = 0;
        int buying_price = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buying_price) {
                total_profit += prices[i] - buying_price;
                buying_price = prices[i];
            } else if (prices[i] < buying_price) {
                buying_price = prices[i];
            }
        }

        return total_profit;
    }
}
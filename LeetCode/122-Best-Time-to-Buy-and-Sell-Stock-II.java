class Solution {
    public int maxProfit(int[] prices) {
        int total_profit = 0;
        int selling_price = prices[prices.length - 1];

        for (int i = prices.length - 1; i >= 0; --i) {
            if (prices[i] < selling_price) {
                total_profit += selling_price - prices[i];
                selling_price = prices[i];
            } else if (prices[i] > selling_price) {
                selling_price = prices[i];
            }
        }

        return total_profit;
    }
}
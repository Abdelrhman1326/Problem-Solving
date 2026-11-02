class Solution {
    public int maxProfit(int[] prices) {
        int max_num = prices[prices.length - 1];
        int max_profit = 0;
        for (int i = prices.length - 2; i >= 0; --i) {
            if (prices[i] > max_num) {
                max_num = prices[i];
            } else {
                max_profit = Math.max(max_profit, (max_num - prices[i]));
            }
        }

        return max_profit;
    }
}
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0]; // Initialize minPrice to the first price
        int maxProfit = 0; // Initialize maxProfit to 0
        int index = 0; // Initialize index of minPrice
        
        for (int i = 1; i < prices.length; i++) {
            // Update minPrice and index if the current price is lower
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                index = i;
            }
            // Update maxProfit if selling at the current price would yield a higher profit
            else if (i > index && prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}

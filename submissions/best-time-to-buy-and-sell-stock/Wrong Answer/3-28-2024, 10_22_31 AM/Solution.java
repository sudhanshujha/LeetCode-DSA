// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int index = prices[0];
        int max = 0;
        for (int i =0; i<prices.length; i++){
            if (prices[i]<min){
                min = prices[i];
                index = i;
            } 
            if (prices[i]>max && i>index) max = prices[i];
        }
        System.out.println(max);
        System.out.println(min);
        return max-min>0? max-min:0;
    }
}
// https://leetcode.com/problems/online-stock-span

import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    List<int[]> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;
        int index = prices.size() - 1;

        // Iterate backward through the prices list
        while (index >= 0 && prices.get(index)[0] <= price) {
            span += prices.get(index)[1]; // Add the span of the previous price
            index -= prices.get(index)[1]; // Move to the previous price
        }

        // Add the current price and its span to the list
        prices.add(new int[]{price, span});

        return span;
    }
}

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> bcandies = new ArrayList<>();
        int max = 0;
        
        // Find max in array
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        
        // Check if adding extraCandies makes current candies count >= max
        for (int candy : candies) {
            bcandies.add(candy + extraCandies >= max);
        }
        
        return bcandies;
    }
}

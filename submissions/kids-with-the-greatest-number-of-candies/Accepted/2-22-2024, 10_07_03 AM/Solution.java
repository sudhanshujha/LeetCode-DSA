// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = -1;
        for (int num : candies) {
            maxi = Math.max(num, maxi);
        }

        List<Boolean> res = new ArrayList<>();

        for (int num : candies) {
            res.add(num + extraCandies >= maxi);
        }

        return res;
    }
}
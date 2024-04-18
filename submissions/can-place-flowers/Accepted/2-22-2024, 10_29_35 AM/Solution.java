// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        // count zeroes having prev & next element as zeroes only
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    count++;
                    i++; // Move to next position as we've placed a flower
                }
            }
        }
        return n <= count;
    }
}

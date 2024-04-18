// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == length - 1 || flowerbed[i + 1] == 0);
                if (prevEmpty && nextEmpty) {
                    count++;
                    i++; // Skip next position as we've placed a flower
                }
            }
        }
        return n <= count;
    }
}

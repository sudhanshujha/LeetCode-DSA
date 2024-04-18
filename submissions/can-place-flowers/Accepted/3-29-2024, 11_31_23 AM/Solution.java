// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // count a[i]=0 with left & right zeroes
        int m = flowerbed.length;
        int count = 0;
        for (int i=0; i<m; i++){
             if (flowerbed[i] == 0) {
                if ((i==0 || flowerbed[i-1]==0) && (i==m-1 || flowerbed[i+1]==0)){
                    count++;
                    i++;
                }
            }
        }
        return n<=count;
    }
}
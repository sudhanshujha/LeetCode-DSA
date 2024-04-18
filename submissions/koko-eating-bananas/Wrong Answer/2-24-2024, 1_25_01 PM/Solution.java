// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    // start making equi sized groups of k size with k starting from 1 till max of array, 
    // return when the ans matches with h

    int k = 1;
    int htemp;
    int max = piles[0];
    for(int i=0;i<piles.length;i++){
        if(piles[i]>max)
            max = piles[i];
    }
    while(k<=max){
        htemp = eatKoko(k,piles);
        if (htemp == h)
            return k;
        k++;
    }
    return k;
    // if(k > max array) return -1
    // if htemp = h -> return k 
    }
    int eatKoko(int k,int[] piles){
        int htemp=0;
        for(int i=0;i<piles.length;i++){
            htemp+= Math.ceil((double)piles[i]/k);            
        }
        return htemp;
    }
}
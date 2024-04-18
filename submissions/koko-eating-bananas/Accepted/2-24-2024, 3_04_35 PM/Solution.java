// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    // start making equi sized groups of k size with k starting from 1 till max of array, 
    // return when the ans matches with h

    int htemp;
    int max = Arrays.stream(piles).max().getAsInt();
    
    int low = 1;
    int high = max;
    int mid;
    while(low<=high){
        
        mid = low + (high -low)/2;
        htemp = eatKoko(mid,piles);

        if(htemp<=h){
            high=mid-1;
        }
        else {
            low=mid+1;
        }
    }
    return low;
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
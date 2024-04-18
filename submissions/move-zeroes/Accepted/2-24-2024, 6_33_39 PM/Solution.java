// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
     //iterate thru array & keep a count of no of zeros while removing them from array &
     // shifting the next element to it's place
    
    int count=0; int i=0;
    int size = nums.length;

    for(;i<size;i++){
        if(nums[i]==0)  count++;
        else nums[i-count]=nums[i];
    }  
    for(i=1;i<=count;i++){
        nums[size-i]=0;
    }
    }
}

// [0,1,2,3,0,12]
// [1,2,3,12,0,0]
// []
// Algo:

// [move all elements to left] temp=index with zero - O(n-1) add on jth position the zero
// // 
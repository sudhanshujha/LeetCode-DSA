// https://leetcode.com/problems/find-greatest-common-divisor-of-array

//Euclidean Algo
class Solution {
    public int findGCD(int[] nums) {
        //find max & min
        int min = nums[0], max = nums[0];
        for(int i: nums){
            if(i>max)
                max=i;
            if(i<min)
                min=i;
        }        
        //start diving max from min
        
        while (min!=0){
            int temp = min;
            min = max%min;
            max = temp;
        }
        return max;
    }
}

// max =6, min =4
// 6/4 =1(int) -useless just keep checking if max/min ==0 -> min ==0 return
// 6%4 = 2 
// 4%2

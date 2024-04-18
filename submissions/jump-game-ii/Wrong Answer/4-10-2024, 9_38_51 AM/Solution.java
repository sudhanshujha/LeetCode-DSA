// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int step = 0, maxReach = 0, currJump = 0, n = nums.length;
        // for each find when we reach end
        for(int i=0; i<n; i++){
            if(maxReach < i+nums[i]){
                maxReach = Math.max(maxReach, i+nums[i]);
                step = step + 1;
            }    
            if(maxReach >= n-1) return step;
        }
        return step;
    }
}
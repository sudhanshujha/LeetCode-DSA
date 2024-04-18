// https://leetcode.com/problems/continuous-subarray-sum

// 2 ptr
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize the map with the sum 0 at index -1
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k; // Handle the case when k is not 0
            
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true; // Check if subarray length is at least 2
            } else {
                map.put(sum, i);
            }
        }
        
        return false;
    }
}

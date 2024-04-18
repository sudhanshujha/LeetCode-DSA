// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with 0 sum frequency as 1
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            int complement = sum - k;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}

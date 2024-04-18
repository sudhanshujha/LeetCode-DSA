// https://leetcode.com/problems/3sum

class Solution {
     public  List<List<Integer>> threeSum(int[] nums) {
        
        // res = result
        Set<List<Integer>> res  = new HashSet<>();
        int n = nums.length;

        // if array size is zero
        if (n==0) return new ArrayList<>(res);
        // sort it for using 2 ptr
        Arrays.sort(nums);

        for(int i = 0; i<n-2; i++){
            int j = i + 1;    // i should be different from j
            int k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }
        }
        return new ArrayList<>(res);
    }
}
// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int j = 0;
        int k = 0;
        int sum = 0;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i < n-2;i++){
            if( (i>0) && nums[i] == nums[i-1]){
                continue;
            }
            j = i+1;
            k = n-1;

            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    k--;
                    j++;
                    while(nums[j] == nums[j-1] && j < k){
                        j++;
                    }
                } 
            }
        }
        return ans;
    }
}
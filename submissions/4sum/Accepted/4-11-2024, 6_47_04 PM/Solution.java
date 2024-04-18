// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int left=j+1,right=n-1;
                long sum=(long)target-((long)nums[i]+(long)nums[j]);
                while(left<right){
                    if(sum-nums[left]==nums[right]){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[j]); 
                        temp.add(nums[left]); temp.add(nums[right]);
                        set.add(temp); left++; right--;
                    }
                    else if(sum-nums[left]>nums[right]) left++;
                    else right--;
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>(set);
        return ans;
    }
}
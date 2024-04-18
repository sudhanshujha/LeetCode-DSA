// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)  return result;
        List<Integer> cur = new ArrayList<>();
        backtracking(nums, 0, cur, result);
        return result;
    }
    private void backtracking(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        backtracking(nums, index + 1, cur, result);
        cur.remove(cur.size() - 1);
        backtracking(nums, index + 1, cur, result);
    }
}
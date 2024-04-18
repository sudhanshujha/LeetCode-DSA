// https://leetcode.com/problems/find-the-difference-of-two-arrays

import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Move all elements of both arrays to 2 hashsets
        // answer[0] = nums1 set - intersection of nums1 and nums2
        // answer[1] = nums2 set - intersection of nums2 and nums1
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        // Find the intersection of nums1Set and nums2Set
        Set<Integer> intersection = new HashSet<>(nums1Set);
        intersection.retainAll(nums2Set);

        // Remove intersection elements from nums1Set and nums2Set
        nums1Set.removeAll(intersection);
        nums2Set.removeAll(intersection);

        // Convert sets to lists
        List<Integer> onlyInNums1 = new ArrayList<>(nums1Set);
        List<Integer> onlyInNums2 = new ArrayList<>(nums2Set);

        // Create the result list
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(onlyInNums1);
        answer.add(onlyInNums2);

        return answer;
    }
}

// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the entry set by frequency in descending order
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Step 3: Add top k keys to the result array
        int[] result = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            result[index++] = entry.getKey();
            if (index == k) {
                break;
            }
        }

        return result;
    }
}
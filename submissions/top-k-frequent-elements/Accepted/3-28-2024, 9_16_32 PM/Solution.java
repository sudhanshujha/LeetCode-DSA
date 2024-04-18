// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min-heap to store top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (entry1, entry2) -> entry1.getValue() - entry2.getValue()
        );

        // Step 3: Iterate through the frequency map and maintain the min-heap with top k frequent elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if heap size exceeds k
            }
        }

        // Step 4: Extract top k frequent elements from the min-heap
        int[] result = new int[k];
        int index = k - 1; // Start filling the result array from the end
        while (!minHeap.isEmpty()) {
            result[index--] = minHeap.poll().getKey();
        }

        return result;
    }
}
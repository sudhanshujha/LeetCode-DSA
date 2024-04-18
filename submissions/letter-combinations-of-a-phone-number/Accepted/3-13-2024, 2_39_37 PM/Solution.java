// https://leetcode.com/problems/letter-combinations-of-a-phone-number

//iterative
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Mapping of digits to letters
        String[] mappings = {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        
        for (char digit : digits.toCharArray()) {
            int size = queue.size();
            String letters = mappings[digit - '2'];
            for (int i = 0; i < size; i++) {
                String prefix = queue.poll();
                for (char letter : letters.toCharArray()) {
                    queue.offer(prefix + letter);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        return result;
    }
}

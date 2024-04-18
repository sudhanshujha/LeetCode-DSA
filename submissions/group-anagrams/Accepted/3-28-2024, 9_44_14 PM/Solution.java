// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            // if map does not contain the key
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            // if map contains the key
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
// {
//   "aet": ["eat", "tea", "ate"],
//   "ant": ["tan", "nat"],
//   "abt": ["bat"]
// }
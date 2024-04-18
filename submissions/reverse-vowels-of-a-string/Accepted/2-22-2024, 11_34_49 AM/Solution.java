// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        // Convert the string to a character array for easy manipulation
        char[] chars = s.toCharArray();
        
        // Define vowels set for constant-time lookup
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
        
        // Initialize two pointers, one at the beginning and one at the end of the string
        int left = 0, right = chars.length - 1;
        
        // Iterate until the pointers meet or cross each other
        while (left < right) {
            // Move the left pointer to the next vowel from the left side
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            
            // Move the right pointer to the next vowel from the right side
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            
            // Swap the vowels found by the left and right pointers
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                
                // Move the pointers towards the center
                left++;
                right--;
            }
        }
        
        // Convert the character array back to a string
        return new String(chars);
    }
}

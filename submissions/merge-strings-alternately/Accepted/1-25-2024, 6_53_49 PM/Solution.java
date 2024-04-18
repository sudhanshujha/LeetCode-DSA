// https://leetcode.com/problems/merge-strings-alternately



// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         String[] mergedString = new String[word1.length + word2.length]; 
//         if(word1.length() > word2.length()) 
//             {
//                 String str = word1;
//                 word1 = word2;
//                 word2 = str;
//             }      
//         for (int i = 0; i < word1.length(); i++) {
//             for (int j=0; j < word2.length(); j++){
//                 mergedstring.append(word1.charAt(i)+word2.charAt(j));
//             }
//     }
// }

class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Integer tlength = word1.length() + word2.length();
        // String[] mergedString = new String[tlength];
        
        // StringBuilder to concatenate characters
        StringBuilder result = new StringBuilder();
        if(word1.length() <= word2.length()) 
        {
            for (int i = 0; i < word1.length(); i++) {
            result.append(word1.charAt(i)).append(word2.charAt(i));
            }
        
            // Add the remaining characters from the longer string
            result.append(word2.substring(word1.length()));

        }
        else
        {
            for (int i = 0; i < word2.length(); i++) {
            result.append(word1.charAt(i)).append(word2.charAt(i));
            }
        
            // Add the remaining characters from the longer string
            result.append(word1.substring(word2.length()));

        }
        return result.toString();
    }
}

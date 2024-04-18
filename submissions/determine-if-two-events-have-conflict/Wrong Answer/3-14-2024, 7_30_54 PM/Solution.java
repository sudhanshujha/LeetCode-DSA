// https://leetcode.com/problems/determine-if-two-events-have-conflict

// h1, m1 = event1
// h2, m2 = event2
// return h2 <= h1 <= m2 or h1 <= h2 <= m1

// compare to 
// if (string1 > string2) it returns a positive value.
// if both the strings are equal lexicographically i.e.(string1 == string2) it returns 0.
// if (string1 < string2) it returns a negative value.
// string1.compareTo(string2)!=0

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        // Extract the end time of event1 and the start time of event2 for overlap
        if (event1[1].compareTo(event2[0]) >= 0) {
            return true; // There is a conflict
        }
        
        // Check the other possible scenario
        if (event2[1].compareTo(event1[0]) <= 0) {
            return true; // There is a conflict
        }
        
        return false; // No conflict
    }
}

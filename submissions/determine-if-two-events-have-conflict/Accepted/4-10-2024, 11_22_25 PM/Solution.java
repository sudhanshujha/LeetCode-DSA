// https://leetcode.com/problems/determine-if-two-events-have-conflict

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // 2 cases only in which case no conflict will occur are
        // if event1 started after event2 ended => end1 < start2
        // if event2 started after event1 ended => end2 < start1
        if (event1[1].compareTo(event2[0])<0)
            return false;
        if (event2[1].compareTo(event1[0])<0) 
            return false;
        // else
            return true;  
    }
}
// https://leetcode.com/problems/determine-if-two-events-have-conflict

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Convert time strings to integers for comparison
        int start1 = convertToMinutes(event1[0]);
        int end1 = convertToMinutes(event1[1]);
        int start2 = convertToMinutes(event2[0]);
        int end2 = convertToMinutes(event2[1]);

        // If event1 started after event2 ended, there is no conflict
        if (start1 > end2) {
            return false;
        }
        // If event1 ended before event2 started, there is no conflict
        if (end1 < start2) {
            return false;
        }
        // If none of the above conditions are met, there is a conflict between the two events
        return true;
    }

    // Helper method to convert time string to minutes
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
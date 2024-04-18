// https://leetcode.com/problems/time-based-key-value-store

import java.util.*;

class Mtype {
    String key;
    String value;
    int timestamp;

    public Mtype(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    List<Mtype> a;

    public TimeMap() {
        a = new ArrayList<>();
    }

    public void set(String key, String value, int timestamp) {
        // Create a new Mtype object
        Mtype m = new Mtype(key, value, timestamp);
        
        // Find the correct position to insert based on timestamp
        int index = 0;
        while (index < a.size() && a.get(index).timestamp <= timestamp) {
            index++;
        }
        
        // Insert the new Mtype object at the correct position
        a.add(index, m);
    }

    public String get(String key, int timestamp) {
        // Perform binary search to find the correct timestamp
        int low = 0;
        int high = a.size() - 1;
        int resultIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid).timestamp == timestamp) {
                resultIndex = mid;
                break;
            } else if (a.get(mid).timestamp < timestamp) {
                resultIndex = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // Return the value corresponding to the found timestamp
        if (resultIndex != -1 && a.get(resultIndex).key.equals(key)) {
            return a.get(resultIndex).value;
        } else if (resultIndex == -1) {
            return "";
        } else {
            // Search for the previous entry with the same key
            for (int i = resultIndex; i >= 0; i--) {
                if (a.get(i).key.equals(key)) {
                    return a.get(i).value;
                }
            }
            return "";
        }
    }
}

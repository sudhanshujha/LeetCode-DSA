// https://leetcode.com/problems/time-based-key-value-store

import java.util.*;

class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        
        // Perform binary search on the list of timestamp-value pairs
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                if (mid == list.size() - 1 || list.get(mid + 1).timestamp > timestamp) {
                    return list.get(mid).value;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        
        return "";
    }
    
    private static class Pair {
        int timestamp;
        String value;
        
        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

// https://leetcode.com/problems/time-based-key-value-store

class Pair {
    int timestamp;
    String val;

    Pair(int timestamp, String val) {
        this.timestamp = timestamp;
        this.val = val;
    }
}

public class TimeMap {

    private HashMap<String, ArrayList<Pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(new Pair(timestamp, value));
        } else {
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(timestamp, value));
            hashMap.put(key, arr);
        }
    }

    public String get(String key, int timestamp) {

        String cand = "";

        if (hashMap.containsKey(key)) {
            ArrayList<Pair> arr = hashMap.get(key);
            int low = 0, high = arr.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int timeVal = arr.get(mid).timestamp;
                if (timeVal == timestamp) {
                    return arr.get(mid).val;
                } else if (timeVal < timestamp) {
                    cand = arr.get(low).val;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return cand;
    }

}

// https://leetcode.com/problems/number-of-recent-calls

class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList();
        //  Initializes counter with zero recent requests.
    }
    public int ping(int t) {
        q.add(t);
        if(q.peek()<(t-3000))
            q.poll(); 
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
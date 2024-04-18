// https://leetcode.com/problems/smallest-number-in-infinite-set

class SmallestInfiniteSet {
    PriorityQueue<Integer> q;
    int count;
    public SmallestInfiniteSet() {
        q = new PriorityQueue<>();
        count =1;
    }
    
    public int popSmallest() {
         if (q.isEmpty() || count < q.peek()) {
        int smallest = count;
        count++;
        return smallest;
    } else {
        return q.poll();
    }
    }
    
    public void addBack(int num) {
        if(count > num && !q.contains(num)) q.add(num);
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
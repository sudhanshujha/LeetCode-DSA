// https://leetcode.com/problems/smallest-number-in-infinite-set

class SmallestInfiniteSet {
    PriorityQueue<Integer> minHeap;
    public SmallestInfiniteSet() { 
        minHeap = new PriorityQueue<>();
        for (int i=1; i<=1000; i++)
            minHeap.offer(i);
    }
    
    public int popSmallest() {
        // for (Integer v : a) another way to iterate on set
        Iterator<Integer> i = minHeap.iterator(); 
        if (minHeap.isEmpty())
            return 1;
        return minHeap.poll(); // Returns root in the min-heap without removing
    }
    
    public void addBack(int num) {
        if (!minHeap.contains(num))
            // Add num to minHeap
            minHeap.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
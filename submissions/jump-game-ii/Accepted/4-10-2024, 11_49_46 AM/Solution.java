// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] A) {
	int jumps = 0, curEnd = 0, curFarthest = 0;
    // implicit BFS
	for (int i = 0; i < A.length - 1; i++) {
		curFarthest = Math.max(curFarthest, i + A[i]);
		// Visited all the items on the current level
        // Increment the level
        // Make the queue size for the next level
      
        if (i == curEnd) {
			jumps++;
			curEnd = curFarthest;
		}
	}
	return jumps;
    }
}
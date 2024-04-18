// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0, minutes = 0;

        // Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) freshOranges++;
                else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        // BFS to rot neighboring oranges
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}

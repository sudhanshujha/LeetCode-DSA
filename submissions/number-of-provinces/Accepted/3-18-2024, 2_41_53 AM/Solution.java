// https://leetcode.com/problems/number-of-provinces

// adjacency matrix
// simple way is just do noemal dfs traversal of the graph
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n]; // to keep count of visited nodes
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}

// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<Integer> op = new ArrayList<>();
        ArrayList<Integer> keys = new ArrayList<>();
        int[] visited = new int[rooms.size()];
        //.size()used for list & length for arraylist
        helper(visited,op,0,rooms);
        return op.size()==rooms.size();
    }
    public void helper(int[] visited, ArrayList<Integer> op, int currNode,List<List<Integer>> rooms){
       op.add(currNode);
       visited[currNode] = 1;
       for(int key: rooms.get(currNode)){
           if(visited[key]!=1)  helper(visited,op,key,rooms);
       }
    }
}

// public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
//         ArrayList<Integer> op = new ArrayList<>();
//         int[] visited = new int[V];
//         helper(adj, visited, op, 0);
//         return op;
//     }
//     
// public void helper(ArrayList<ArrayList<Integer>> adjList, int[] visited, ArrayList<Integer> op, int currNode){
//         op.add(currNode);
//         visited[currNode] = 1;
//         for(int adjNode: adjList.get(currNode)){
//             if(visited[adjNode]!=1) helper(adjList, visited, op, adjNode);
//         }
//     }
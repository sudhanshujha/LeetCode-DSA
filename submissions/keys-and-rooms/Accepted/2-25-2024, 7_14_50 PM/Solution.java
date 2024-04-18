// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        helper(rooms, visited, 0);
        for(int i: visited) if(i==0) return false;
        return true;
    }

    public void helper(List<List<Integer>> rooms, int[] visited, int currRoom){
        visited[currRoom] = 1;
        for(int adjRoom: rooms.get(currRoom)){
            if(visited[adjRoom]!=1) helper(rooms, visited, adjRoom);
        }
    }
}
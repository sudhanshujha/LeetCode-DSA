// https://leetcode.com/problems/equal-row-and-column-pairs


class Solution {
    //  TC O(m*n)

    public int equalPairs(int[][] grid) {
        int n = grid.length, ans = 0, idx = 0 ;
        Map<String, Integer> rowHash = new HashMap<>();
        Map<String, Integer> colHash = new HashMap<>();

        for(int[] row: grid){ // Calculate hash of each row
            StringBuilder sb = new StringBuilder();
            for(int i : row){
                sb.append(i).append("#");
            }
            rowHash.put(sb.toString(), rowHash.getOrDefault(sb.toString(), 0)+1);
        }
        for(int j=0; j<n; j++){  // Calculate hash of each col
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                sb.append(grid[i][j]).append("#");
            }

            colHash.put(sb.toString(), colHash.getOrDefault(sb.toString(), 0)+1);

        }

        for(Map.Entry<String, Integer> entry : rowHash.entrySet()){
            String rHash = entry.getKey();
            if(colHash.containsKey(rHash)){
                ans += colHash.get(rHash) * rowHash.get(rHash);
            }
        }
        return ans;
    }
}
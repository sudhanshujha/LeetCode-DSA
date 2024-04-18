// https://leetcode.com/problems/equal-row-and-column-pairs


// Transpose and compare using Arrays.equals

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int [][] flip = new int[n][n];
        
        transpose(grid,flip);
        
        int count = 0;
        
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<n; j++){
                if(Arrays.equals(grid[i],flip[j]))
                    count++;
            }
        }
        
        return count;
        
    }
    public void transpose(int [][] src , int [][] target){
        for(int  i = 0; i<src.length; i++){
            for(int j = 0; j<src[0].length; j++){
                target[i][j] = src[j][i];
            }
        }
    }
}
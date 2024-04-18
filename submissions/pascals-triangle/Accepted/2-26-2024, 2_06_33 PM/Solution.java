// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        //Bottom up aproach
        if(numRows>=1){
            pascal.add(Arrays.asList(1));
        }
        if(numRows>=2){
            pascal.add(Arrays.asList(1, 1));
        }
        for(int i=2;i<numRows;++i){ 
            List<Integer> row = new ArrayList<>();
                row.add(1);         // First element is always 1
                for(int j=0;j<i-1;++j){        
                    // pascal[2][1] = pascal[1][0] + pascal[1][1] 
                    // pascal[3][1] = pascal[2][0] + pascal[2][1]        
                    int sum = pascal.get(i-1).get(j) + pascal.get(i-1).get(j+1);
                    row.add(sum);       // Set the calculated sum at next index
                }
                row.add(1);         // Last element is always 1
            // Add the row to the Pascal's triangle
            pascal.add(row);
        }
        return pascal;
    }
}
// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element is always 1
            for (int j = 1; j < i; ++j) {
                // Calculate the sum based on the values from the previous row
                int sum = pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j);
                // pascal[2][1] = pascal[1][0] + pascal[1][1] 
                // pascal[3][1] = pascal[2][0] + pascal[2][1]  
                row.add(sum); 
            }
            if (i > 0) {
                row.add(1); // Last element is always 1, except for the first row
            }
            // Add the row to the Pascal's triangle
            pascal.add(row);
        }
        return pascal;
    }
}

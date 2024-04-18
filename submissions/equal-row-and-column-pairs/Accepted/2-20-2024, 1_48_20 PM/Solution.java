// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
  class Node {
    Map<Integer, Node> next = new HashMap<>();
    int cnt;
  }

  public int equalPairs(int[][] grid) {
    int n = grid.length, ans = 0;
    var root = new Node();

    for (var row : grid) {
      var ptr = root;

      for (var val : row) {
        if (ptr.next.containsKey(val))
          ptr = ptr.next.get(val);
        else {
          var newNode = new Node();
          ptr.next.put(val, newNode);
          ptr = newNode;
        }
      }
      ptr.cnt++;
    }
    for (var i=0; i<n; i++) {
      var ptr = root;

      for (var j=0; j<n; j++) {
        if (ptr.next.containsKey(grid[j][i]))
          ptr = ptr.next.get(grid[j][i]);
        else break;
      }
      ans += ptr.cnt;
    }
    return ans;
  }
}
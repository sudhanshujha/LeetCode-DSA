// https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
public:
  int numTilings(int n) {
    unsigned int a = 1, b = 2, c = 5, mod = 1000000007;
    
    for(n -= 3; n > 0 ; n--){
      int d = ((c<<1) + a) % mod;
      a = b;
      b = c;
      c = d;
    }
    
    return n == -2 ? a : n == -1 ? b : c;
  }
};
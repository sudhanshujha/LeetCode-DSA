// https://leetcode.com/problems/guess-number-higher-or-lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, mid, result;  // n is right
        while (left <= n) {
            mid = left + (n - left) / 2;
            result = guess(mid);
            if (result == 0) {
                return mid; // Found the correct number
            } else if (result < 0) {
                n = mid - 1; // Reduce the search space to the left of mid
            } else {
                left = mid + 1; // Reduce the search space to the right of mid
            }
        }
        return -1; // Not found (should not happen according to the problem)
    }
}

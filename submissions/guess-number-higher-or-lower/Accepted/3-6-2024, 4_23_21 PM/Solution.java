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
        return guessNumberRecursive(1, n);
    }
    
    private int guessNumberRecursive(int left, int right) {
        if (left == right) {
            return left; // Found the correct number
        }
        
        int mid = left + (right - left) / 2;
        int result = guess(mid);
        
        if (result == 0) {
            return mid; // Found the correct number
        } else if (result < 0) {
            return guessNumberRecursive(left, mid); // Search in the left half
        } else {
            return guessNumberRecursive(mid + 1, right); // Search in the right half
        }
    }
}


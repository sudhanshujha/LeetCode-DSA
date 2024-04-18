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
        while(guess(n)!=0){
            if(guess(n)<0)
                n--;
            else if(guess(n)>0)
                n++;
        }
        return n;
    }
}
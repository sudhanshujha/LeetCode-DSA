// https://leetcode.com/problems/fibonacci-number

class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int t0=0, t1=1;
        int t2;
        for(int i=2;i<=n;i++){
            t2=t1+t0;
            t0=t1;
            t1=t2;
        }
        return t1;
    }
}
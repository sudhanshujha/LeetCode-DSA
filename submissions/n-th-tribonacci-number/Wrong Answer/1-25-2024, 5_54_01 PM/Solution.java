// https://leetcode.com/problems/n-th-tribonacci-number

class Solution {
    public int tribonacci(int n) {
        int t2 =1, t1 =1, t0=0;
        int t3=0;   
            for(int i=1; i<=n-2; i++)
            {
                t3=t2+t1+t0;
                t0=t1;
                t1=t2;
                t2=t3;
            }
        return t3;
        //calc tn =tn-1+tn-2 store & keep doing this
    }
}
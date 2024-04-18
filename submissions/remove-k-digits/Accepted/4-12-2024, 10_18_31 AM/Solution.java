// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();
        int keep = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            while (res.length() > 0 && res.charAt(res.length() - 1) > num.charAt(i) && k > 0) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(num.charAt(i));
        }
        res.delete(keep, res.length());

        // Trim leading zeros
        int s = 0;
        while (s < res.length() - 1 && res.charAt(s) == '0') s++;
        res.delete(0, s);

        return res.length() == 0 ? "0" : res.toString();
    }
}
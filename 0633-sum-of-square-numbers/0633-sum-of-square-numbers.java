class Solution {
    public boolean judgeSquareSum(int c) {
        long lo = 0;
        long hi = (int) Math.ceil(Math.sqrt(c));
        while (lo <= hi) {
            long mid = (lo * lo) + (hi * hi);
            if (mid == c)
                return true;
            if (mid < c) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }
}
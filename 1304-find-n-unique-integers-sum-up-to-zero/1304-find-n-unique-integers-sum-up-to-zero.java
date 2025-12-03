class Solution {
    public int[] sumZero(int n) {
        int res[] = new int[n];
        int start = -1 * (n / 2);
        int len = n % 2 == 0 ? n : n - 1;
        for (int i = 0; i < len; i++) {
            int curr = 0;
            if (start == 0)
                curr = ++start;
            curr = start++;
            res[i] = curr;
        }
        return res;
    }
}
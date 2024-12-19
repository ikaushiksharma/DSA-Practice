class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                res++;
            }
        }
        return res;
    }
}
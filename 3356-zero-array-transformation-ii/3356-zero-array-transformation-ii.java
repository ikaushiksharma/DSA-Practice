class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int lo = 0;
        int hi = queries.length + 1;
        int res = -1;
        if (Arrays.stream(nums).allMatch(x -> x == 0))
            return 0;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(nums, mid, queries)) {
                res = mid;
                hi = mid;
            } else
                lo = mid + 1;
        }
        return res;
    }

    private boolean isPossible(int nums[], int k, int[][] q) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int left = q[i][0], right = q[i][1], val = q[i][2];
            diff[left] += val;
            diff[right + 1] -= val;
        }
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i];
            if (currVal < nums[i])
                return false;
        }
        return true;
    }
}
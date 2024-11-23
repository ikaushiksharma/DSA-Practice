class Solution {
    public static boolean hasSplitPoint(int s, int e, int sum, int m) {
        return sum >= m || (e - s + 1) == 1;
    }

    public boolean canSplitArray(List<Integer> nums, int m) {
        int memo[][] = new int[nums.size() + 1][nums.size() + 1];
        int totalSum = 0;
        for (int i : nums)
            totalSum += i;
        return isSplitArray(nums, 0, nums.size() - 1, m, totalSum, memo);
    }

    private boolean isSplitArray(List<Integer>nums, int start, int end, int m, int sum, int dp[][]) {
        if (start == end)
            return true;
        if (dp[start][end] != 0)
            return dp[start][end] == 1;
        int curr = 0, remain = 0;
        for (int i = start; i < end; i++) {
            curr += nums.get(i);
            remain = sum - curr;
            boolean shouldSplit = hasSplitPoint(start, i, curr, m) && hasSplitPoint(i + 1, end, remain, m);
            if (shouldSplit && isSplitArray(nums, start, i, m, curr, dp)
                    && isSplitArray(nums, i + 1, end, m, remain, dp)) {
                dp[start][end] = 1;
                return true;
            }
        }
        dp[start][end] = -1;
        return false;

    }
}
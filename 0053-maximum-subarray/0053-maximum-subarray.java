class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            maxSum = curr > maxSum ? curr : maxSum;
            if (curr < 0) {
                curr = 0;
            }
        }
        return maxSum;

    }
}
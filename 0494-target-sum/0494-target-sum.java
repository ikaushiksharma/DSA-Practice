class Solution {
    int cnt = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return cnt;
    }

    private void calculate(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target)
                cnt++;
            return;
        }
        calculate(nums, i + 1, sum + nums[i], target);
        calculate(nums, i + 1, sum - nums[i], target);
    }
}
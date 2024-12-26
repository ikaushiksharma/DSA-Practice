class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int memo[][] = new int[nums.length + 1][2*sum+1];
        for (int mem[] : memo)
            Arrays.fill(mem, -1);
        return calculate(nums, 0, 0, target, memo,sum);
    }

    private int calculate(int[] nums, int i, int sum, int target, int memo[][],int total) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (memo[i][total+sum] != -1)
            return memo[i][total+sum];
        return memo[i][total+sum] = calculate(nums, i + 1, sum + nums[i], target, memo,total)
                + calculate(nums, i + 1, sum - nums[i], target, memo,total);
    }
}
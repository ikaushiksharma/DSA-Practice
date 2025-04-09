class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] < k)
            return -1;
        int op = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                op++;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    ++i;
                }
            }
        }
        return op;
    }
}
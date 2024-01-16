class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = -1; // !!
        long sum = 0;

        for (int num : nums) {
            if (prev == num)
                continue; // !!
            if (num <= k) {
                k++;
                sum += num;
            } else {
                break;
            }
            prev = num; // !!
        }

        long res = (long) (1 + k) * k / 2 - sum;
        return res;
    }
}
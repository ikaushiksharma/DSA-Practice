class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int mod[] = new int[k];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= k;
            if (nums[i] < 0)
                nums[i] += k;
            mod[nums[i]]++;
        }
        int cnt = mod[0];
        for (int i : mod) {
            if (i > 1) {
                cnt += (i * (i - 1)) / 2;
            }
        }
        return cnt;
    }
}
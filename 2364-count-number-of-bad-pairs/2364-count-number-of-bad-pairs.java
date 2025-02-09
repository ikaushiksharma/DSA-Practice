class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int prev = mp.getOrDefault(nums[i] - i, 0);
            cnt += prev;
            mp.put(nums[i] - i, prev + 1);
        }
        return 1L * n * (n - 1) / 2 - cnt;
    }
}
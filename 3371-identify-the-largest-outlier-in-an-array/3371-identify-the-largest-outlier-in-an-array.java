class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int res = -1000;
        for (int i : nums) {
            int tmp = sum - i;
            if (Math.abs(tmp % 2) == 1) {
                continue;
            }
            tmp /= 2;
            if (freq.containsKey(tmp) && (i != tmp || freq.get(i) != 1)) {
                res = Math.max(res, i);
            }
        }
        return res;
    }
}
class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int i = 0;
        int j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (i < nums.length && map.lastKey() - map.firstKey() > 2) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            ans += j - i + 1;
            j++;

        }
        return ans;
    }
}
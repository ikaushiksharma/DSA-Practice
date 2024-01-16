class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        long cnt=k;
        for (int num : nums) {
            if (!set.contains(num) && num <= (int)cnt) {
                cnt++;
                sum += num;
            }
            set.add(num);

        }
        long res = (long) ((cnt * (cnt + 1)) / 2) - sum;
        return res;
    }
}
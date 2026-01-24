class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                major = num;
                cnt++;
            } else if (major == num) {
                cnt++;
            } else
                cnt--;
        }
        return major;
    }
}

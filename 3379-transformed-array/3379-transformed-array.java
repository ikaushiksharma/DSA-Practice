class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
                int dist=0;
                if(nums[i]<0) dist=i-Math.abs(nums[i])+n;
                else if(nums[i]>0) dist=Math.abs(nums[i])+i;
                int idx = (dist) % n;
                result[i] = nums[idx];
        }
        return result;
    }
}
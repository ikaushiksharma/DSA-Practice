class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int sum=nums[lo++]+nums[hi--];
            max=Math.max(sum,max);
        }
        return max;
    }
}
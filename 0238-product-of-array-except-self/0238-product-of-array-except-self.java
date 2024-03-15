class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int lo=1;
        int hi=1;
        int res[]=new int[n];
        Arrays.fill(res,1);
        for(int i=0;i<n;i++){
            res[i]*=lo;
            lo*=nums[i];
            res[n-1-i]*=hi;
            hi*=nums[n-1-i];
        }
        return res;
    }
}
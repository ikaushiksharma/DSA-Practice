class Solution {
    int mod=(int)(1e9+7);
    public int maxSumMinProduct(int[] nums) {
        // Arrays.sort(nums);
        int n=nums.length;
        long pSum[]=new long[n+1];
        long res=0;
        for(int i=0;i<n;i++) pSum[i+1]=pSum[i]+nums[i];
        int[] s=new int[n];
        int top=-1;
        for(int i=0;i<=n;s[++top]=i++){
            while(top>=0 && (i==n || nums[i]<nums[s[top]])){
                int min=nums[s[top--]];
                int l=top==-1?0:s[top]+1;
                int r=i-1;
                res=Math.max(res,min*(pSum[r+1]-pSum[l]));
            }
        }
        return (int)(res%mod);
    }
}
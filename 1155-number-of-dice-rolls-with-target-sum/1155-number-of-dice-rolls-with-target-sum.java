class Solution {
    final int mod=(int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return helper(n,k,target,dp);
    }
    int helper(int n,int k,int target,int dp[][]){
        if(target==0 && n==0) return 1;
        if(n==0 || target<=0) return 0;
        if(dp[n][target]!=-1) return dp[n][target]%mod;
        int ways=0;
        for(int i=1;i<=k;i++){
            ways=(ways+helper(n-1,k,target-i,dp))%mod;
        }
        return dp[n][target]=ways%mod;
    }
}
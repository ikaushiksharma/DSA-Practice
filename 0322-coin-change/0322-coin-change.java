class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][]=new int[coins.length][amount+1];
        for(int d[]:dp) Arrays.fill(d,-1);
        int res=helper(coins,coins.length-1,amount,dp);
        return res>=(int)(1e9+7)?-1:res;
    }
    int helper(int coins[],int idx,int amt,int dp[][]){
        if(amt==0){
            return 0;
        }
        if(idx<0){
            return (int)(1e9+7);
        }
        if(dp[idx][amt]!=-1) return dp[idx][amt];
        int pick=(int)(1e9+7);
        if(coins[idx]<=amt){
            pick=1+helper(coins,idx,amt-coins[idx],dp);
        }
        int notPick=helper(coins,idx-1,amt,dp);
        return dp[idx][amt]=Math.min(pick,notPick);
    }
}
class Solution {
    int sum=0;
    public int numDecodings(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }
    private int helper(String s,int idx,int dp[]){
        if(idx>=s.length()) {
            return 1;
        }
        if(dp[idx]!=-1) return dp[idx];
        int pick1=0;
        int pick2=0;
        if(s.charAt(idx)!='0'){
            pick1=helper(s,idx+1,dp);
            if(idx<s.length()-1 && (s.charAt(idx)<'2' || (s.charAt(idx)=='2' && s.charAt(idx+1)<='6')))
            pick2=helper(s,idx+2,dp);
        }
        return dp[idx]=pick1+pick2;
    }
}
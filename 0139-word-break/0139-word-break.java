class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[] = new Boolean[s.length() + 1];
        return helper(s, wordDict, 0, dp);
    }

    private boolean helper(String s, List<String> wordDict, int pos, Boolean dp[]) {
        if (pos == s.length())
            return true;
        if(dp[pos]!=null) return dp[pos];
        for(String word:wordDict){
            if(s.startsWith(word,pos) && helper(s,wordDict,pos+word.length(),dp)){
                return dp[pos]=true;
            }
        }
        return dp[pos]=false;
    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int d[] : dp)
            Arrays.fill(d, -1);
        return helper(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    private int helper(String s1, String s2, int i, int j, int dp[][]) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        char a = s1.charAt(i);
        char b = s2.charAt(j);
        if (a == b)
            return dp[i][j] = 1 + helper(s1, s2, i - 1, j - 1,dp);
        return dp[i][j] = Math.max(helper(s1, s2, i - 1, j,dp), helper(s1, s2, i, j - 1,dp));
    }
}
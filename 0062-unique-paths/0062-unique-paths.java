class Solution {
    public int uniquePaths(int m, int n) {
        if (n < 1 || m < 1)
            return 0;
        if (n == 1 && m == 1)
            return 1;
        int memo[][] = new int[m][n];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return helper(m-1, n-1, memo);
    }

    private int helper(int m, int n, int memo[][]) {
        if (n < 0 || m < 0)
            return 0;
        if (n == 0 && m == 0)
            return 1;
        if(memo[m][n]!=-1) return memo[m][n];
        memo[m][n]=helper(m-1,n,memo)+helper(m,n-1,memo);
        return memo[m][n];
    }
}
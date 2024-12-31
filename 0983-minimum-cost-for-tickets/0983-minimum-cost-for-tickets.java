class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int memo[][] = new int[days.length][400];
        for (int m[] : memo)
            Arrays.fill(m, -1);
        return helper(days, costs, memo, 0, 0);
    }

    private int helper(int days[], int cost[], int memo[][], int i, int reach) {
        if (i == days.length)
            return 0;
        if (memo[i][reach] != -1)
            return memo[i][reach];

        return memo[i][reach] = days[i] > reach ? Math.min(cost[0] + helper(days, cost, memo, i + 1, days[i]),
                Math.min(cost[1] + helper(days, cost, memo, i + 1, days[i] + 6),
                        cost[2] + helper(days, cost, memo, i + 1, days[i] + 29)))
                : helper(days, cost, memo, i + 1, reach);
    }
}
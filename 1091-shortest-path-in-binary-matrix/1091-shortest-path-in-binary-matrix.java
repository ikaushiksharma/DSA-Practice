class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == n - 1 && y == n - 1)
                    return cnt;
                for (int j = -1; j < 2; j++) {
                    for (int k = -1; k < 2; k++) {
                        if (j == 0 && k == 0)
                            continue;
                        int r = x + j;
                        int c = y + k;
                        if (r < 0 || r > n - 1 || c < 0 || c > n - 1 || grid[r][c] != 0)
                            continue;
                        grid[r][c] = 2;
                        q.offer(new int[] { r, c });
                    }
                }
            }
        }

        return -1;
    }
}

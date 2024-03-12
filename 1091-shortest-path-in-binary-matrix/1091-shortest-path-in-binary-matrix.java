class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return -1;
        }

        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;
        q.add(new Pair(0, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            for (int i = 0; i < q.size(); i++) {
                Pair node = q.poll();
                if(node.x==n-1 && node.y==m-1) return ans;
                for (int[] dir : dirs) {
                    int row = node.x + dir[0];
                    int col = node.y + dir[1];
                    if (row < n && row >= 0 && col < m && col >= 0 && vis[row][col] == false && grid[row][col] == 0) {
                        q.offer(new Pair(row, col));
                        vis[row][col] = true;
                    }
                }
            }
        }
        return -1;
    }
}
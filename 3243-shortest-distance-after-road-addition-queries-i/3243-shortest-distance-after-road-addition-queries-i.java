class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer>[] roads = new ArrayList[n];
        for (int i = 0; i < n - 1; i++) {
            roads[i] = new ArrayList<Integer>();
            roads[i].add(i + 1);
        }
        int res[] = new int[queries.length];
        roads[n - 1] = new ArrayList<Integer>();
        for (int i = 0; i < queries.length; i++) {
            roads[queries[i][0]].add(queries[i][1]);
            res[i] = getMinDistance(0, n - 1, roads);
        }
        return res;
    }

    private int getMinDistance(int source, int destination, ArrayList<Integer>[] road) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        q.add(source);
        int level = 0;
        while (!q.isEmpty()) {
            int city = q.poll();
            level++;
            for (int next : road[city]) {
                if(next==destination) return level;
                q.add(next);
            }
        }
        return -1;
    }
}